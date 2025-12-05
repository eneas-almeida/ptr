# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot 4.0.0 application built with Java 21 and Maven. The project combines both reactive (WebFlux) and traditional servlet-based (Web MVC) web frameworks, with JDBC-based session management.

## Build and Development Commands

### Build and Run
```bash
# Build the project
./mvnw clean package

# Run the application
./mvnw spring-boot:run

# Run tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=PtrApplicationTests

# Run a specific test method
./mvnw test -Dtest=ClassName#methodName
```

### Other Maven Commands
```bash
# Clean build artifacts
./mvnw clean

# Compile without running tests
./mvnw clean compile -DskipTests

# Generate project reports
./mvnw site
```

## Architecture

This project follows **Clean Architecture** principles with reactive programming using WebFlux. The architecture is organized in layers with clear separation of concerns:

### Layer Structure

```
org.ptr/
├── domain/              # Enterprise Business Rules
│   ├── entity/         # Domain entities
│   └── usecase/        # Use case interfaces
├── application/         # Application Business Rules
│   └── usecase/        # Use case implementations
├── infrastructure/      # Frameworks & Drivers
│   ├── client/         # External API clients (WebClient)
│   ├── repository/     # Data access interfaces/implementations
│   └── config/         # Spring configuration
└── presentation/        # Interface Adapters
    ├── controller/     # REST controllers
    └── dto/            # Data Transfer Objects
```

### Key Architectural Patterns

1. **Dependency Rule**: Dependencies point inward. Domain layer has no dependencies on outer layers.
2. **Use Cases**: All business logic is encapsulated in use cases implementing `UseCase<I, O>` interface.
3. **Reactive Chains**: External API calls are chained using `flatMap` for sequential reactive operations.
4. **WebClient**: All external HTTP calls use Spring WebClient with proper timeout configuration.

### Example Flow

Controller (presentation) → Use Case (application) → External API Client (infrastructure)
- Controllers receive HTTP requests and delegate to use cases
- Use cases orchestrate business logic and chain external API calls
- External clients handle HTTP communication reactively

## Project Structure

- **Package**: `org.ptr`
- **Main class**: `PtrApplication.java` - Standard Spring Boot application entry point
- **Configuration**: `application.properties` - Application configuration (currently minimal)
- **Java version**: 21

## Key Dependencies

- **spring-boot-starter-webflux**: Reactive web framework support (primary framework)
- **spring-boot-starter-webmvc**: Traditional Spring MVC support (available if needed)
- **spring-boot-starter-session-jdbc**: JDBC-based session management

## Testing

Tests use JUnit 5 (Jupiter) and Spring Boot Test framework. The default test configuration includes support for testing both WebFlux and Web MVC components.