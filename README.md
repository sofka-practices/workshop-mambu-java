## Taller: Refactorización del ejemplo utilizando Spring Boot y WebFlux

Descripción:
En este taller, vamos a refactorizar el ejemplo proporcionado utilizando Spring Boot y el módulo WebFlux de Spring Framework. Utilizaremos la programación reactiva para manejar las transacciones de manera más eficiente y escalable. Al final del taller, tendremos una aplicación Spring Boot funcional que realiza las mismas transacciones que el ejemplo original.

Pasos a seguir:

1. Configuración del proyecto:
   - Crear un nuevo proyecto Spring Boot utilizando Spring Initializr.
   - Agregar las dependencias necesarias: Spring WebFlux, Spring Data Reactive MongoDB y Reactor Core.

2. Creación de las clases de modelo:
   - Crear las clases de modelo necesarias, como `Client`, `Account` y `Transaction`, utilizando anotaciones de Spring Data Reactive MongoDB.

3. Configuración de la conexión a la base de datos:
   - Configurar la conexión a la base de datos MongoDB en el archivo de configuración de Spring Boot, como `application.properties` o `application.yaml`.

4. Creación de los controladores:
   - Crear un controlador llamado `ClientController` utilizando la anotación `@RestController`.
   - Implementar los endpoints necesarios para las transacciones, como la creación de un cliente, la creación de una cuenta, el depósito, el retiro, la consulta de saldo y la transferencia bancaria.

5. Implementación de los servicios:
   - Crear un servicio llamado `ClientService` para manejar la lógica de negocio de las transacciones.
   - Inyectar el repositorio de MongoDB para interactuar con la base de datos.
   - Implementar métodos reactivos en el servicio para realizar las operaciones de creación de cliente, creación de cuenta, depósito, retiro, consulta de saldo y transferencia bancaria.

6. Implementación de los repositorios:
   - Crear una interfaz llamada `ClientRepository` que extienda `ReactiveMongoRepository<Client, String>` para interactuar con la colección de clientes en la base de datos.
   - Crear una interfaz llamada `AccountRepository` que extienda `ReactiveMongoRepository<Account, String>` para interactuar con la colección de cuentas en la base de datos.

7. Pruebas y validación:
   - Ejecutar la aplicación y probar los endpoints utilizando una herramienta de prueba de API, como Postman o cURL.
   - Verificar que las transacciones se realicen correctamente y se devuelvan las respuestas esperadas.

8. Mejoras adicionales:
   - Agregar validaciones de entrada en los controladores utilizando las anotaciones de validación de Spring.
   - Implementar manejo de errores y excepciones utilizando las capacidades de manejo de errores de Spring WebFlux.

9. Documentación:
   - Crear una documentación clara y concisa que explique cómo utilizar la API y los diferentes endpoints disponibles.


Flujo de transacciones a implementar:

1. Crear un nuevo cliente:
   - Endpoint: `POST /clients`
   - Parámetros de entrada: Información del cliente (nombre, correo electrónico, etc.)
   - Lógica: Crear un nuevo documento de cliente en la base de datos.

2. Crear una cuenta de ahorros para el cliente:
   - Endpoint: `POST /accounts`
   - Parámetros de entrada: ID del cliente
   - Lógica: Crear una nueva cuenta de ahorros asociada al cliente en la base de datos.

3. Depositar dinero en la cuenta de ahorros:
   - Endpoint: `POST /accounts/{accountId}/deposits`
   - Parámetros de entrada: ID de la cuenta, cantidad a depositar
   - Lógica

: Realizar un depósito en la cuenta de ahorros especificada.

4. Realizar un retiro:
   - Endpoint: `POST /accounts/{accountId}/withdrawals`
   - Parámetros de entrada: ID de la cuenta, cantidad a retirar
   - Lógica: Realizar un retiro de la cuenta de ahorros especificada.

5. Consultar el saldo de la cuenta de ahorros:
   - Endpoint: `GET /accounts/{accountId}/balance`
   - Parámetros de entrada: ID de la cuenta
   - Lógica: Consultar el saldo actual de la cuenta de ahorros especificada.

6. Realizar una transferencia bancaria:
   - Endpoint: `POST /accounts/{sourceAccountId}/transfers`
   - Parámetros de entrada: ID de la cuenta de origen, ID de la cuenta de destino, cantidad a transferir
   - Lógica: Realizar una transferencia de fondos desde la cuenta de origen a la cuenta de destino.

Recursos adicionales:
- Documentación de Spring Boot: https://spring.io/projects/spring-boot
- Documentación de Spring WebFlux: https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html

¡Disfruta el taller de refactorización utilizando Spring Boot y WebFlux!

Recursos adicionales:
- Documentación de Spring Boot: https://spring.io/projects/spring-boot
- Documentación de Spring WebFlux: https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html

Para ver el ejemplo de refactorización utilizando Spring Boot y WebFlux, puedes consultar el archivo `MainSnippet.java` que se encuentra en el siguiente enlace: [MainSnippet.java](https://github.com/sofka-practices/workshop-mambu-java/MainSnippet.java)

¡Disfruta el taller de refactorización utilizando Spring Boot y WebFlux!
