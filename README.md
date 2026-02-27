# Employee Management System

A production-ready Spring Boot backend implementation focused on RESTful service design and centralized error management.

---

## Technical Architecture
The project follows a standard layered architecture to ensure a clear separation of concerns:

* **Controller Layer**: Exposes REST API endpoints and handles incoming HTTP requests (e.g., `users.java`).
* **Service Layer**: Contains the core business logic within the `employeeService` class.
* **Repository Layer**: Implements the Data Access Object (DAO) pattern using `EntityManager` for manual database interaction.
* **Exception Layer**: Provides a global strategy for error handling, returning consistent responses for custom exceptions.



---

## API Documentation
The following endpoints provide full CRUD capabilities for the employee database:

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/getEmployees` | Retrieves a comprehensive list of all employees. |
| **GET** | `/api/getEmployee/{id}` | Fetches details for a specific employee by ID. |
| **POST** | `/api/addEmployee` | Creates and persists a new employee record. |
| **PUT** | `/api/updateEmployee` | Updates data for an existing employee. |
| **DELETE** | `/api/deleteEmployee/{id}` | Removes an employee record from the database. |

---

## Technology Stack
* **Language**: Java 17+
* **Framework**: Spring Boot 3
* **Persistence**: JPA / Hibernate
* **Database**: MySQL
* **Build Tool**: Maven

---

## Configuration Details
To run this project locally, configure your MySQL credentials in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
spring.datasource.username=root
spring.datasource.password=your_password_here
