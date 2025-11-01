### README for BeatBox Music App

#### Project Overview
The **BeatBox Music App** is a Spring Boot-based REST API application for managing user authentication, songs, playlists, and playback functionality. It uses Maven for dependency management and follows the OpenAPI 3.0 specification for API documentation.

---

#### Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.example.beatbox/   # Main Java package
│   │       ├── controllers/       # REST controllers for handling API requests
│   │       ├── services/          # Business logic and service layer
│   │       ├── repositories/      # Data access layer (JPA repositories)
│   │       ├── models/            # Entity and DTO classes
│   │       └── config/            # Configuration files (e.g., security, Swagger)
│   ├── resources/
│   │   ├── application.properties # Application configuration
│   │   └── BeatBox_Swagger.json   # OpenAPI specification for the API
│   └── webapp/                    # Static resources (if applicable)
├── test/
│   └── java/                      # Unit and integration tests
└── pom.xml                        # Maven configuration file
```

---

#### Key Components

1. **Controllers**:
    - Handle HTTP requests and map them to service methods.
    - Example: `PlaylistController`, `SongController`, `PlaybackController`.

2. **Services**:
    - Contain business logic for the application.
    - Example: `PlaylistService`, `AuthenticationService`.

3. **Repositories**:
    - Interface with the database using Spring Data JPA.
    - Example: `PlaylistRepository`, `SongRepository`.

4. **Models**:
    - Define entities and DTOs used in the application.
    - Example: `PlaylistDTO`, `SongDTO`, `UserDTO`.

5. **Configuration**:
    - Includes security configurations (e.g., JWT authentication) and Swagger setup.

---

#### API Documentation
The API is documented using OpenAPI 3.0. The specification is available in `src/main/resources/BeatBox_Swagger.json`. Use tools like Swagger UI or Postman to explore the API.

---

#### Build and Run
1. **Build**: Use Maven to build the project.
   ```bash
   mvn clean install
   ```
2. **Run**: Start the application.
   ```bash
   mvn spring-boot:run
   ```
3. **Access**:
    - API Base URL: `http://localhost:8080`
    - Swagger UI: `http://localhost:8080/swagger-ui.html` (if configured)

---

#### Dependencies
- **Spring Boot**: Core framework for the application.
- **Spring Data JPA**: For database interactions.
- **Spring Security**: For authentication and authorization.
- **Swagger/OpenAPI**: For API documentation.
- **H2/MySQL**: Database (configurable in `application.properties`).

---

#### Security
The application uses JWT-based authentication. Secure endpoints require a valid token in the `Authorization` header.

---

#### Testing
Unit and integration tests are located in the `src/test/java` directory. Use the following command to run tests:
```bash
mvn test
```

---

This structure ensures modularity, scalability, and maintainability of the application.


#### ScreenShots
Register User
<img width="1509" height="707" alt="image" src="https://github.com/user-attachments/assets/38392bcc-63e8-4691-b8eb-0af56508991c" />

After Registration Use Same Account to Login
<img width="1444" height="686" alt="image" src="https://github.com/user-attachments/assets/6efbdc21-d268-4bac-9d02-d7d782a83631" />

Use the token from login api as a authorization to execute all other endpoints


Add Songs
<img width="1909" height="952" alt="image" src="https://github.com/user-attachments/assets/a21ae5bc-e74b-45ac-9892-386457562cfe" />

Get Songs
<img width="1807" height="1008" alt="image" src="https://github.com/user-attachments/assets/03de6a85-60fd-45fb-bb4b-f3128c42f86b" />

Created Playlist 
<img width="1817" height="966" alt="image" src="https://github.com/user-attachments/assets/bac8fcc9-4c7b-4062-8f75-5b4ca6ccd7d2" />

Get User Playlists including songs
<img width="1908" height="977" alt="image" src="https://github.com/user-attachments/assets/18918f38-1b74-4bba-aceb-24924e6f9d26" />





