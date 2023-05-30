## Taller: Refactorización del código a una API con Spring Boot utilizando la API de Mambu

Descripción:
En este taller, vamos a refactorizar el código proporcionado para convertirlo en una API utilizando Spring Boot y la API de Mambu. Utilizaremos Spring Web para crear los endpoints de la API y Spring RestTemplate para interactuar con la API de Mambu. Al final del taller, tendremos una aplicación Spring Boot funcional que ofrece los mismos servicios que el código original.

Pasos a seguir:

1. Configuración del proyecto:
   - Crear un nuevo proyecto Spring Boot utilizando Spring Initializr.
   - Agregar las dependencias necesarias: Spring Web y Spring RestTemplate.

2. Configuración de la conexión con Mambu:
   - Obtener las credenciales de acceso a la API de Mambu.
   - Configurar las credenciales en el archivo de configuración de Spring Boot, como `application.properties` o `application.yaml`.

3. Creación de los controladores:
   - Crear un controlador llamado `TransactionController` utilizando la anotación `@RestController`.
   - Implementar los endpoints necesarios para las transacciones, como la creación de un cliente, la creación de una cuenta, el depósito, el retiro, la consulta de saldo y la transferencia bancaria.

4. Implementación de los servicios:
   - Crear un servicio llamado `TransactionService` para manejar la lógica de negocio de las transacciones.
   - Inyectar `RestTemplate` para realizar las llamadas a la API de Mambu.
   - Implementar métodos en el servicio para realizar las operaciones de creación de cliente, creación de cuenta, depósito, retiro, consulta de saldo y transferencia bancaria.

5. Configuración de las rutas y controladores:
   - Configurar las rutas y los controladores en el archivo de configuración de Spring Boot, como `application.properties` o `application.yaml`.

6. Pruebas y validación:
   - Ejecutar la aplicación y probar los endpoints utilizando una herramienta de prueba de API, como Postman o cURL.
   - Verificar que las transacciones se realicen correctamente y se devuelvan las respuestas esperadas.

7. Documentación:
   - Crear una documentación clara y concisa que explique cómo utilizar la API y los diferentes endpoints disponibles.

Flujo de transacciones a implementar:

1. Crear un nuevo cliente:
   - Endpoint: `POST /clients`
   - Parámetros de entrada: Información del cliente (nombre, correo electrónico, etc.)
   - Lógica: Crear un nuevo cliente en Mambu utilizando la API.

2. Crear una cuenta de ahorros para el cliente:
   - Endpoint: `POST /clients/{clientId}/accounts`
   - Parámetros de entrada: ID del cliente
   - Lógica: Crear una nueva cuenta de ahorros asociada al cliente en Mambu utilizando la API.

3. Depositar dinero en la cuenta de ahorros:
   - Endpoint: `POST /accounts/{accountId}/deposits`
   - Parámetros de entrada: ID de la cuenta, cantidad a depositar
   - Lógica: Realizar un depósito en la cuenta de ahorros especificada en Mambu utilizando la API.

4. Realizar un retiro:
   - Endpoint: `POST /accounts/{accountId}/withdrawals`
   - Parámetros de entrada: ID de la cuenta, cantidad a retirar
   - L

ógica: Realizar un retiro de la cuenta de ahorros especificada en Mambu utilizando la API.

5. Consultar el saldo de la cuenta de ahorros:
   - Endpoint: `GET /accounts/{accountId}/balance`
   - Parámetros de entrada: ID de la cuenta
   - Lógica: Consultar el saldo actual de la cuenta de ahorros especificada en Mambu utilizando la API.

6. Realizar una transferencia bancaria:
   - Endpoint: `POST /accounts/{sourceAccountId}/transfers`
   - Parámetros de entrada: ID de la cuenta de origen, ID de la cuenta de destino, cantidad a transferir
   - Lógica: Realizar una transferencia de fondos desde la cuenta de origen a la cuenta de destino en Mambu utilizando la API.

Recursos adicionales:
- Documentación de Spring Boot: https://spring.io/projects/spring-boot
- Documentación de Spring Web: https://docs.spring.io/spring-framework/docs/current/reference/html/web.html
- Documentación de Spring RestTemplate: https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#rest-client-access


Para ver el ejemplo de refactorización utilizando Spring Boot y WebFlux, puedes consultar el archivo `MainSnippet.java` que se encuentra en el siguiente enlace: [MainSnippet.java](https://github.com/sofka-practices/workshop-mambu-java/MainSnippet.java)

¡Disfruta el taller de refactorización para convertir el código en una API con Spring Boot y la API de Mambu!
