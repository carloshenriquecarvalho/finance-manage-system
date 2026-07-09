# Financial Management System

A REST API built with **Spring Boot** that helps companies manage their finances by tracking income and expenses in a simple and organized way.

---

## Features

* User authentication with JWT
* Income management
* Expense management
* PostgreSQL database
* Database versioning with Flyway
* Spring Security authentication
* RESTful API

---

## Tech Stack

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* PostgreSQL
* Flyway
* Maven
* JUnit 5

---

## Demo

The image below shows an example of a request and its response.

<img src="" alt="API Demo"/>

---

## Installation

Clone the repository:

```bash
git clone <project-url>
```

Navigate to the project directory:

```bash
cd finance-manage-system
```

Install the dependencies:

```bash
mvn clean install
```

---

## Configuration

Start PostgreSQL using Docker:

```bash
docker compose up -d
```

Create an `application.properties` file:

```properties
spring.application.name=finance-manage-system

spring.datasource.url=jdbc:postgresql://localhost:5432/finance_manage_system
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=validate

security.jwt.secret=<YOUR_SECRET_KEY>
security.jwt.expiration=7200000
```

---

## Running the Project

Run the application using Maven:

```bash
mvn spring-boot:run
```

Or start it directly from your IDE.

---

## Database

This project uses **Flyway** for database version control.

All migrations are executed automatically when the application starts.

---

## Testing

Run the tests with:

```bash
mvn test
```

---

## License

This project is available for educational purposes.
