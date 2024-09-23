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

## API Endpoints Guide

### Base URL
All endpoints are prefixed with `/api`. The full URL will be `http://localhost:8081/api`.

---

### Session Endpoints

#### 1. **Get All Sessions**
- **Endpoint**: `GET /sessions`
- **Description**: Retrieve a list of all fitness sessions.
- **Response**:
  - **200 OK**: List of `SessionEntity` objects.

#### 2. **Create a New Session**
- **Endpoint**: `POST /sessions/create`
- **Description**: Create a new fitness session.
- **Request Body**:
  - `CreateSessionRequest` object containing session details (e.g., name, date).
- **Response**:
  - **201 Created**: `CreateSessionResponse` object with session ID.
  - **400 Bad Request**: If session creation fails.

#### 3. **Update Session by ID**
- **Endpoint**: `PUT /sessions/{id}`
- **Description**: Update an existing session by ID.
- **Path Variable**:
  - `id`: ID of the session to update.
- **Request Body**:
  - `CreateSessionRequest` object with updated session details.
- **Response**:
  - **200 OK**: Updated `SessionEntity`.
  - **404 Not Found**: If session with given ID does not exist.

#### 4. **Get Session by ID**
- **Endpoint**: `GET /sessions/{id}`
- **Description**: Retrieve a specific session by ID.
- **Path Variable**:
  - `id`: ID of the session to retrieve.
- **Response**:
  - **200 OK**: `SessionEntity` object.
  - **404 Not Found**: If session with given ID does not exist.

#### 5. **Delete Session by ID**
- **Endpoint**: `DELETE /sessions/{id}`
- **Description**: Delete a specific session by ID.
- **Path Variable**:
  - `id`: ID of the session to delete.
- **Response**:
  - **200 OK**: Message indicating success.
  - **404 Not Found**: If session with given ID does not exist.

---

### Exercise Endpoints

#### 1. **Create a New Exercise**
- **Endpoint**: `POST /exercise/{sessionId}`
- **Description**: Create a new exercise for a specific session.
- **Path Variable**:
  - `sessionId`: ID of the session to which the exercise will be added.
- **Request Body**:
  - `CreateExerciseRequest` object containing exercise details (e.g., name, description).
- **Response**:
  - **201 Created**: `CreateExerciseResponse` object with exercise details.

#### 2. **Get Exercise by ID**
- **Endpoint**: `GET /exercise/{id}`
- **Description**: Retrieve a specific exercise by ID.
- **Path Variable**:
  - `id`: ID of the exercise to retrieve.
- **Response**:
  - **200 OK**: `ExerciseEntity` object.
  - **404 Not Found**: If exercise with given ID does not exist.

#### 3. **Get All Exercises**
- **Endpoint**: `GET /exercise`
- **Description**: Retrieve a list of all exercises.
- **Response**:
  - **200 OK**: List of `ExerciseEntity` objects.

#### 4. **Update Exercise**
- **Endpoint**: `PUT /exercise/{id}`
- **Description**: Update an existing exercise by ID.
- **Path Variable**:
  - `id`: ID of the exercise to update.
- **Request Body**:
  - `CreateExerciseRequest` object with updated exercise details.
- **Response**:
  - **200 OK**: Updated `ExerciseEntity`.
  - **404 Not Found**: If exercise with given ID does not exist.

#### 5. **Delete Exercise**
- **Endpoint**: `DELETE /exercise/{id}`
- **Description**: Delete a specific exercise by ID.
- **Path Variable**:
  - `id`: ID of the exercise to delete.
- **Response**:
  - **204 No Content**: If successful.
  - **404 Not Found**: If exercise with given ID does not exist.

---

### Set Endpoints

#### 1. **Create a New Set**
- **Endpoint**: `POST /set`
- **Description**: Create a new set for an exercise.
- **Request Body**:
  - `CreateSetRequest` object containing set details (e.g., repetitions, weight).
- **Response**:
  - **201 Created**: `CreateSetResponse` object with set details.

#### 2. **Get Set by ID**
- **Endpoint**: `GET /set/{id}`
- **Description**: Retrieve a specific set by ID.
- **Path Variable**:
  - `id`: ID of the set to retrieve.
- **Response**:
  - **200 OK**: `SetEntity` object.
  - **404 Not Found**: If set with given ID does not exist.

#### 3. **Get All Sets**
- **Endpoint**: `GET /set`
- **Description**: Retrieve a list of all sets.
- **Response**:
  - **200 OK**: List of `SetEntity` objects.

#### 4. **Update Set**
- **Endpoint**: `PUT /set/{id}`
- **Description**: Update an existing set by ID.
- **Path Variable**:
  - `id`: ID of the set to update.
- **Request Body**:
  - `CreateSetRequest` object with updated set details.
- **Response**:
  - **200 OK**: Updated `SetEntity`.
  - **404 Not Found**: If set with given ID does not exist.

#### 5. **Delete Set**
- **Endpoint**: `DELETE /set/{id}`
- **Description**: Delete a specific set by ID.
- **Path Variable**:
  - `id`: ID of the set to delete.
- **Response**:
  - **204 No Content**: If successful.

---

### Authentication
Ensure you are authenticated to access these endpoints. Use the login functionality provided in your application to obtain a session token or use form-based login, depending on your security configuration.

---

### Example Requests
- **Create a New Session**:
  ```json
  POST /api/sessions/create
  {
      "name": "Leg Day",
      "sessionDate": "2024-09-22"
  }


## API Endpoints Guide

### Base URL
All endpoints are prefixed with `/api`. The full URL will be `http://localhost:8081/api`.

---

### Session Endpoints

#### 1. **Get All Sessions**
- **Endpoint**: `GET /sessions`
- **Description**: Retrieve a list of all fitness sessions.
- **Response**:
  - **200 OK**: List of `SessionEntity` objects.

#### 2. **Create a New Session**
- **Endpoint**: `POST /sessions/create`
- **Description**: Create a new fitness session.
- **Request Body**:
  - `CreateSessionRequest` object containing session details (e.g., name, date).
- **Response**:
  - **201 Created**: `CreateSessionResponse` object with session ID.
  - **400 Bad Request**: If session creation fails.

#### 3. **Update Session by ID**
- **Endpoint**: `PUT /sessions/{id}`
- **Description**: Update an existing session by ID.
- **Path Variable**:
  - `id`: ID of the session to update.
- **Request Body**:
  - `CreateSessionRequest` object with updated session details.
- **Response**:
  - **200 OK**: Updated `SessionEntity`.
  - **404 Not Found**: If session with given ID does not exist.

#### 4. **Get Session by ID**
- **Endpoint**: `GET /sessions/{id}`
- **Description**: Retrieve a specific session by ID.
- **Path Variable**:
  - `id`: ID of the session to retrieve.
- **Response**:
  - **200 OK**: `SessionEntity` object.
  - **404 Not Found**: If session with given ID does not exist.

#### 5. **Delete Session by ID**
- **Endpoint**: `DELETE /sessions/{id}`
- **Description**: Delete a specific session by ID.
- **Path Variable**:
  - `id`: ID of the session to delete.
- **Response**:
  - **200 OK**: Message indicating success.
  - **404 Not Found**: If session with given ID does not exist.

---

### Exercise Endpoints

#### 1. **Create a New Exercise**
- **Endpoint**: `POST /exercise/{sessionId}`
- **Description**: Create a new exercise for a specific session.
- **Path Variable**:
  - `sessionId`: ID of the session to which the exercise will be added.
- **Request Body**:
  - `CreateExerciseRequest` object containing exercise details (e.g., name, description).
- **Response**:
  - **201 Created**: `CreateExerciseResponse` object with exercise details.

#### 2. **Get Exercise by ID**
- **Endpoint**: `GET /exercise/{id}`
- **Description**: Retrieve a specific exercise by ID.
- **Path Variable**:
  - `id`: ID of the exercise to retrieve.
- **Response**:
  - **200 OK**: `ExerciseEntity` object.
  - **404 Not Found**: If exercise with given ID does not exist.

#### 3. **Get All Exercises**
- **Endpoint**: `GET /exercise`
- **Description**: Retrieve a list of all exercises.
- **Response**:
  - **200 OK**: List of `ExerciseEntity` objects.

#### 4. **Update Exercise**
- **Endpoint**: `PUT /exercise/{id}`
- **Description**: Update an existing exercise by ID.
- **Path Variable**:
  - `id`: ID of the exercise to update.
- **Request Body**:
  - `CreateExerciseRequest` object with updated exercise details.
- **Response**:
  - **200 OK**: Updated `ExerciseEntity`.
  - **404 Not Found**: If exercise with given ID does not exist.

#### 5. **Delete Exercise**
- **Endpoint**: `DELETE /exercise/{id}`
- **Description**: Delete a specific exercise by ID.
- **Path Variable**:
  - `id`: ID of the exercise to delete.
- **Response**:
  - **204 No Content**: If successful.
  - **404 Not Found**: If exercise with given ID does not exist.

---

### Set Endpoints

#### 1. **Create a New Set**
- **Endpoint**: `POST /set`
- **Description**: Create a new set for an exercise.
- **Request Body**:
  - `CreateSetRequest` object containing set details (e.g., repetitions, weight).
- **Response**:
  - **201 Created**: `CreateSetResponse` object with set details.

#### 2. **Get Set by ID**
- **Endpoint**: `GET /set/{id}`
- **Description**: Retrieve a specific set by ID.
- **Path Variable**:
  - `id`: ID of the set to retrieve.
- **Response**:
  - **200 OK**: `SetEntity` object.
  - **404 Not Found**: If set with given ID does not exist.

#### 3. **Get All Sets**
- **Endpoint**: `GET /set`
- **Description**: Retrieve a list of all sets.
- **Response**:
  - **200 OK**: List of `SetEntity` objects.

#### 4. **Update Set**
- **Endpoint**: `PUT /set/{id}`
- **Description**: Update an existing set by ID.
- **Path Variable**:
  - `id`: ID of the set to update.
- **Request Body**:
  - `CreateSetRequest` object with updated set details.
- **Response**:
  - **200 OK**: Updated `SetEntity`.
  - **404 Not Found**: If set with given ID does not exist.

#### 5. **Delete Set**
- **Endpoint**: `DELETE /set/{id}`
- **Description**: Delete a specific set by ID.
- **Path Variable**:
  - `id`: ID of the set to delete.
- **Response**:
  - **204 No Content**: If successful.

---

### Authentication
Ensure you are authenticated to access these endpoints. Use the login functionality provided in your application to obtain a session token or use form-based login, depending on your security configuration.

---

### Example Requests
- **Create a New Session**:
  ```json
  POST /api/sessions/create
  {
      "name": "Leg Day",
      "sessionDate": "2024-09-22"
  }



