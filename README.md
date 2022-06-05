# API StorageBikes

This is a rest api to provide services to manage many bikes support, like shop or insurance, and give to end-users a way to schedule this support.

## Technologies

- Java 11
- Maven 3.8.5
- Spring Boot 2.7.0
- Swagger 2.9.0

## Development process

This software was developed using these concepts:

- TDD
- Clean Code
- Hexagonal Architecture
- Unit Tests

## How to run the application?

You only need to clone this repository and execute the main class(method main): `ApiStoragebikesApplication`.

- Using maven: `mvn spring-boot:run`

OR

- You can use your IDE

## Swagger

To access the api docs type this in the url: `http://localhost:8080/swagger-ui.html`

## H2 database

To access the memory database type this in the url: `http://localhost:8080/h2-console`

- Settings (*leave the password blank*)
```properties
jdbc url: jdbc:h2:mem:storagebikesdb
usename: sa
```