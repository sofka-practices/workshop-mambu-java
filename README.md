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

Recursos adicionales:
- Documentación de Spring Boot: https://spring.io/projects/spring-boot
- Documentación de Spring WebFlux: https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html

Para ver el ejemplo de refactorización utilizando Spring Boot y WebFlux, puedes consultar el archivo `MainSnippet.java` que se encuentra en el siguiente enlace: [MainSnippet.java](https://github.com/sofka-practices/workshop-mambu-java/MainSnippet.java)

¡Disfruta el taller de refactorización utilizando Spring Boot y WebFlux!
