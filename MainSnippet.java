import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.client.HttpClient;

public class MainSnippet {

    private static final String mambuApiUrl = "https://sofkamambudev.sandbox.mambu.com/api";
    private static final String mambuUser = "---";
    private static final String mambuPassword = "---";
    private static final String productTypeKey = "8a44a104833da611018346fd57e651b6";

    public static void main(String[] args) {
        final String customFieldExternalID = java.util.UUID.randomUUID().toString();

        createClient()
                .flatMap(newClient -> {
                    System.out.println("Created client: " + newClient);
                    return createSavingsAccount(newClient.getString("encodedKey"));
                })
                .flatMap(newAccount -> {
                    System.out.println("Create Savings Account: " + newAccount);
                    double depositAmount = 100;
                    return depositToAccount(newAccount.getString("id"), depositAmount);
                })
                .flatMap(depositResult -> {
                    System.out.println("Deposited to account: " + depositResult);
                    double withdrawAmount = 50;
                    return withdrawFromAccount(depositResult.getString("parentAccountKey"), withdrawAmount);
                })
                .flatMap(withdrawResult -> {
                    System.out.println("Withdrawn from account: " + withdrawResult);
                    double feeAmount = 10;
                    return applyFeeToAccount(withdrawResult.getString("parentAccountKey"), feeAmount);
                })
                .flatMap(feeResult -> {
                    System.out.println("Apply fee to Account: " + feeResult);
                    return getAccountBalance(feeResult.getString("parentAccountKey"));
                })
                .subscribe(accountBalance -> {
                    System.out.println("Account balance: " + accountBalance);
                }, error -> {
                    System.err.println("Error in transaction flow: " + error.getMessage());
                }, () -> {
                    System.out.println("Transaction flow completed");
                });

        // Espera a que las transacciones se completen antes de que termine el programa
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Mono<String> createClient() {
        String clientData = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "emailAddress": "john.doe@example.com",
                    "notes": "Example client",
                    "gender": "MALE",
                    "preferredLanguage": "SPANISH",
                    "_personalizados": {
                        "External_ID": "%s"
                    }
                }
                """.formatted(java.util.UUID.randomUUID().toString());

        return postRequest("/clients", clientData)
                .map(response -> {
                    System.out.println("Created client response: " + response);
                    return response;
                })
                .map(response -> response.getString("encodedKey"))
                .subscribeOn(Schedulers.boundedElastic());
    }

    private static Mono<String> createSavingsAccount(String clientKey) {
        String accountData = """
                {
                    "name": "Savings Account",
                    "accountHolderType": "CLIENT",
                    "accountHolderKey": "%s",
                    "accountState": "APPROVED",
                    "productTypeKey": "%s",
                    "currencyCode": "COP",
                    "allowOverdraft": false
                }
                """.formatted(clientKey, productTypeKey);

        return postRequest("/deposits", accountData)
                .map(response -> {
                    System.out.println("Create Savings Account response: " + response);
                    return response;
                })
                .map(response -> response.getString("id"))
                .subscribeOn(Schedulers.boundedElastic());
    }

    private static Mono<String> depositToAccount(String accountId, double amount) {
        String transactionData = """
                {
                    "amount": %f,
                    "notes": "Initial deposit",
                    "type": "DEPOSIT",
                    "customInformation": []
                }
                """.formatted(amount);

        return postRequest("/deposits/%s/deposit-transactions".formatted(accountId), transactionData)
                .map(response -> {
                    System.out.println("Deposit to account response: " + response);
                    return response;
                })
                .subscribeOn(Schedulers.boundedElastic());
    }

    private static Mono<String> withdrawFromAccount(String accountId, double amount) {
        String transactionData = """
                {
                    "amount": %f,
                    "notes": "Withdrawal transaction",
                    "type": "WITHDRAWAL",
                    "customInformation": []
                }
                """.formatted(amount);

        return postRequest("/deposits/%s/withdrawal-transactions".formatted(accountId), transactionData)
                .map(response -> {
                    System.out.println("Withdraw from account response: " + response);
                    return response;
                })
                .subscribeOn(Schedulers.boundedElastic());
    }

    private static Mono<String> applyFeeToAccount(String accountId, double amount) {
        String transactionData = """
                {
                    "amount": %f,
                    "notes": "Service fee"
                }
                """.formatted(amount);

        return postRequest("/deposits/%s/fee-transactions".formatted(accountId), transactionData)
                .map(response -> {
                    System.out.println("Apply fee to account response: " + response);
                    return response;
                })
                .subscribeOn(Schedulers.boundedElastic());
    }

    private static Mono<Double> getAccountBalance(String accountId) {
        return getRequest("/deposits/%s".formatted(accountId))
                .map(response -> {
                    System.out.println("Get account balance response: " + response);
                    return response;
                })
                .map(response -> response.getJSONObject("balances").getDouble("totalBalance"))
                .subscribeOn(Schedulers.boundedElastic());
    }

    private static Mono<String> postRequest(String path, String body) {
        return HttpClient.create()
                .headers(headers -> headers.add("Content-Type", "application/json")
                        .add("Accept", "application/vnd.mambu.v2+json"))
                .headers(headers -> headers.setBasicAuth(mambuUser, mambuPassword))
                .post()
                .uri(mambuApiUrl + path)
                .sendString(Mono.just(body))
                .responseSingle((response, bodyBytes) -> {
                    if (response.status().code() == 200) {
                        return bodyBytes.asString();
                    } else {
                        throw new RuntimeException("Request failed with code: " + response.status().code());
                    }
                });
    }

    private static Mono<String> getRequest(String path) {
        return HttpClient.create()
                .headers(headers -> headers.add("Accept", "application/vnd.mambu.v2+json"))
                .headers(headers -> headers.setBasicAuth(mambuUser, mambuPassword))
                .get()
                .uri(mambuApiUrl + path)
                .responseSingle((response, bodyBytes) -> {
                    if (response.status().code() == 200) {
                        return bodyBytes.asString();
                    } else {
                        throw new RuntimeException("Request failed with code: " + response.status().code());
                    }
                });
    }
}
