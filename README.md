# Fitness Tracker App

## Overview

The Fitness Tracker App is a Spring Boot application designed to help users track their fitness sessions, exercises, and sets. This app allows users to create sessions, add exercises to those sessions, and log various metrics for each exercise.

## Features

- **Session Management**: Create, read, update, and delete fitness sessions.
- **Exercise Tracking**: Add exercises to sessions, including names and descriptions.
- **Set Logging**: Log detailed metrics for each exercise, including repetitions, weight, and comments.
- **User Roles**: Support for different user roles (USER, ADMIN) to manage access and functionality.
- **Secure Endpoints**: Utilizes Spring Security for authentication and authorization.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For database interactions.
- **MySQL**: Database for storing session, exercise, and set information.
- **Spring Security**: For securing the application and managing user roles.
- **Lombok**: To reduce boilerplate code with annotations.
- **JUnit**: For unit testing.

## Getting Started

### Prerequisites

- Java 17 or higher
- Gradle
- MySQL Server

### Installation

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd fitness-tracker-app

   spring.datasource.url=jdbc:mysql://localhost:3306/fitness_tracker
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>


