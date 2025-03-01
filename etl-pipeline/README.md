# ETL Pipeline

## Project Purpose
This project is a modernization of the legacy ETL (Extract, Transform, Load) process. The goal is to refactor and improve the existing codebase to make it more maintainable and testable.

## Project Structure
```
acme-corp/
  └── etl-pipeline/
      ├── src/
      │   ├── main/
      │   │   └── java/
      │   │       └── com/
      │   │           └── acme/
      │   │               └── legacy/
      │   │                   └── LegacyETL.java
      │   └── test/
      │       └── java/
      │           └── (placeholder for unit tests)
      ├── config/  (for any configuration files)
      └── README.md
```

## Instructions for Refactoring and Testing
1. **Refactoring**:
    - Identify and isolate the core functionalities of the `LegacyETL` class.
    - Break down the monolithic code into smaller, reusable components.
    - Use design patterns where applicable to improve code maintainability.

2. **Testing**:
    - Create unit tests for each refactored component.
    - Use mocking frameworks like Mockito to isolate dependencies.
    - Ensure high code coverage to catch potential issues early.

## Building the Project
To build the project, run the following command in the project root directory:
```sh
mvn clean install
```

## Running Tests
To run the tests, use the following command:
```sh
mvn test
```

## Dependencies
- `org.json:json:20210307` for JSON processing.

## Future Improvements
- Implement logging using a framework like Log4j or SLF4J.
- Add integration tests to ensure the end-to-end functionality of the ETL process.
- Set up a CI/CD pipeline for automated builds and deployments.
