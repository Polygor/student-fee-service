# Student Fee Microservices

## Description
This microservice architecture manages student information, receipts for payments, and payment processing.

## Features
- Manage Students
- Manage Receipts
- Process Payments
- RESTful APIs
- H2 In-memory Database
- Swagger API Documentation

## Microservices
1. **Student Service**: Manages student information.
2. **Receipt Service**: Manages receipts and payment statuses.
3. **Payment Service**: Processes payments and communicates with the Receipt Service.

## How to Run

1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd student-fee-microservice
    ```

2. Build the application:
    ```sh
    cd student-service
    ./mvnw clean install
    cd ../receipt-service
    ./mvnw clean install
    cd ../payment-service
    ./mvnw clean install
    ```

3. Run the application using Docker Compose:
    ```sh
    docker-compose up --build
    ```

4. Access Services:
    - **Student Service**: `http://localhost:8080`
    - **Receipt Service**: `http://localhost:8081`
    - **Payment Service**: `http://localhost:8082`

5. Access H2 Database:
    ```
    URL: http://localhost:<port>/h2-console
    JDBC URL: jdbc:h2:mem:testdb
    User Name: sa
    Password: password
    ```

6. Access Swagger UI:
    ```
    URL: http://localhost:<port>/swagger-ui.html
    ```

## Design & Approach

### Domain Boundaries
- **Student Management**: Handles CRUD operations for students.
- **Receipt Management**: Handles CRUD operations for receipts.
- **Payment Processing**: Handles payment transactions.

### Inter-service Communication
- Services communicate via RESTful APIs.
- The Payment Service communicates with the Receipt Service to update payment status.

### Domain-driven Database Design
- The database tables are designed based on the domain models (Student, Receipt, Payment).

### Failure Handling and Resilience
- Basic exception handling in controllers.
- To enhance resilience, consider using libraries like Hystrix for circuit breakers in a distributed setup.

## Technologies Used
- Java 11
- Spring Boot
- Spring Data JPA
- H2 Database
- Swagger
- Docker
