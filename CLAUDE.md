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

## Project Structure

- **Package**: `org.ptr`
- **Main class**: `PtrApplication.java` - Standard Spring Boot application entry point
- **Configuration**: `application.properties` - Application configuration (currently minimal)
- **Java version**: 21

## Key Dependencies

- **spring-boot-starter-webflux**: Reactive web framework support
- **spring-boot-starter-webmvc**: Traditional Spring MVC support
- **spring-boot-starter-session-jdbc**: JDBC-based session management

Note: This project has both WebFlux (reactive) and Web MVC (servlet) starters, which is unusual. Typically Spring Boot applications use one or the other. This may indicate a transitional architecture or specific requirements for handling both reactive and blocking endpoints.

## Testing

Tests use JUnit 5 (Jupiter) and Spring Boot Test framework. The default test configuration includes support for testing both WebFlux and Web MVC components.