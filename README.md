# Foro Hub API

This project is a stateless RESTful API for managing forum topics ("topicos"). It provides endpoints for creating, updating, retrieving, and deleting topics, with user authentication implemented using JWT tokens. The API is designed to work with a MySQL database and leverages Flyway for managing database migrations.

## Features
- Stateless RESTful API.
- JWT-based authentication with a 2-hour token expiry.
- CRUD operations for "topicos".
- Pagination and sorting support for listing topics.
- Configurable database connection.
- Passwords stored in the database are encrypted using Bcrypt.
- Flyway for database versioning and migrations.
- API documentation available through SpringDoc with Swagger.

## Requirements
- Java 17 or later.
- Maven 3.8 or later.
- MySQL database.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/foro-hub-api.git
   cd foro-hub-api
   ```

2. **Configure Environment Variables**:  
   Add the following variables to your environment or `.env` file:
   ```bash
   DB_HOST=your-database-host
   DB_MYSQL_USER=your-database-username
   DB_MYSQL_PASSWORD=your-database-password
   CHALLENGE_FOROHUB_JWT_SECRET=your-secret-key
   ```

3. **Set Up Database**:  
   The default database name is `challenge_foro_hub`. You can change this in the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:mysql://${DB_HOST}/challenge_foro_hub
   spring.datasource.username=${DB_MYSQL_USER}
   spring.datasource.password=${DB_MYSQL_PASSWORD}
   ```

4. **Run Flyway Migrations**:  
   Migrate your database schema:
   ```bash
   mvn flyway:migrate
   ```

5. **Build and Run the Application**:  
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints
### Authentication
- **Login**: `POST /login`
  - Request Body:
    ```json
    {
      "username": "user",
      "password": "password"
    }
    ```
  - Response:
    ```json
    {
      "token": "your-jwt-token"
    }
    ```
  - Notes:
    - The plain text password from the request is encrypted using Bcrypt and compared with the encrypted password in the database.

### Topicos
- **List Topics**: `GET /topicos`
  - Optional query params: `size`, `page`, `sort`
  - Response: Paginated list of topics.

- **Get Topic by ID**: `GET /topicos/{id}`
  - Replace `{id}` with the topic ID.

- **Create Topic**: `POST /topicos`
  - Request Body:
    ```json
    {
      "titulo": "Topic Title",
      "mensaje": "Topic Message",
      "curso": "Course Name",
      "autor": "Author Name"
    }
    ```

- **Update Topic**: `PUT /topicos/{id}`
  - Request Body:
    ```json
    {
      "titulo": "Updated Title",
      "mensaje": "Updated Message"
    }
    ```

- **Delete Topic**: `DELETE /topicos/{id}`

### API Documentation
- **Swagger UI**: `GET /swagger-ui/index.html`
- **API Docs**: `GET /v3/api-docs`
  - These endpoints are publicly accessible and do not require authentication.

## Notes
- Ensure to replace path variables (e.g., `{id}`) with actual values.
- If you want to use a different database name, update the `spring.datasource.url` property.
- Passwords in the database must be stored in Bcrypt encryption for the login functionality to work.
- Flyway is used to manage all database changes through migrations.
- API documentation is generated using SpringDoc and accessible via Swagger UI.
- Error handling for invalid operations (e.g., accessing a non-existent topic) is managed by a dedicated error handler class.

## Dependencies
The project uses the following dependencies:
- **Spring Boot Starter Data JPA**: For database operations.
- **Spring Boot Starter Security**: For authentication and security.
- **Spring Boot Starter Web**: For building the RESTful API.
- **Flyway Core & Flyway MySQL**: For database migrations.
- **Java JWT (Auth0)**: For creating and validating JWT tokens.
- **MySQL Connector**: To connect with MySQL database.
- **Spring Boot Starter Validation**: For input validation.
- **Spring Boot DevTools**: For development convenience (optional).
- **Bcrypt (Spring Security)**: For secure password encryption and validation.
- **SpringDoc with Swagger**: For friendly API documentation. 

## License
This project is open-source and available under the MIT License.

## Acknowledgements
Special thanks to the creators and maintainers of the dependencies used in this project.
