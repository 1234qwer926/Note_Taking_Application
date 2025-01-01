
# Note-Taking Application

A secure and user-friendly note-taking application built using **Spring Boot**. This application allows users to securely register, log in, and manage personal notes with CRUD (Create, Read, Update, Delete) functionality.

## Features

- **User Authentication**: 
  - Users can register and log in using their credentials.
  - Passwords are securely stored using **BCryptPasswordEncoder**.
  - **JWT (JSON Web Token)** authentication is implemented to secure the endpoints.
  
- **Note Management**:
  - Users can **add**, **view**, **update**, and **delete** their personal notes.
  - Notes are associated with individual users, ensuring data privacy.
  - The application keeps track of the date and time when notes are created.

## Technology Stack

- **Backend**: Spring Boot
- **Database**: MySQL
- **Security**: Spring Security, BCrypt Password Encoding
- **JPA**: Hibernate for database interactions

## Endpoints

### Authentication

- **POST /register**: Register a new user by providing `username` and `password` in the request body.
- **POST /login**: Login with `username` and `password` to receive a **JWT token** for subsequent API requests.

### Note Operations (Requires Authentication)

- **GET /notes**: Get all notes of the logged-in user.
- **POST /notes/add**: Add a new note (Requires `title`, `description` in the request body).
- **GET /notes/{id}**: Get a specific note by `id`.
- **PUT /notes/{id}**: Update an existing note (Requires `title`, `description` in the request body).
- **DELETE /notes/{id}**: Delete a note by `id`.

## Setup

### Prerequisites

- **Java 17+**
- **MySQL 8.0+**

### Steps to Run Locally

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/1234qwer926/Note_Taking_Application.git
   ```

2. **Database Configuration**:
   - Ensure MySQL is running and create a new database named `noteapp`.
   - Update your `application.properties` file with the correct database credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/noteapp
     spring.datasource.username=root
     spring.datasource.password=your_password_here
     ```

3. **Build and Run**:
   - Navigate to the project directory and run:
     ```bash
     ./mvnw spring-boot:run
     ```
   - The application will be available at [http://localhost:8080](http://localhost:8080).

## Example Usage

### 1. Register a New User

```bash
POST /register
Content-Type: application/json

{
  "username": "john_doe",
  "password": "password123"
}
```

### 2. Login

```bash
POST /login
Content-Type: application/json

{
  "username": "john_doe",
  "password": "password123"
}
```
_Response:_
```json
{
  "token": "your_jwt_token_here"
}
```

### 3. Add a Note

```bash
POST /notes/add
Authorization: Bearer your_jwt_token_here
Content-Type: application/json

{
  "title": "My First Note",
  "description": "This is a description of my first note."
}
```

### 4. Get All Notes

```bash
GET /notes
Authorization: Bearer your_jwt_token_here
```

### 5. Update a Note

```bash
PUT /notes/{id}
Authorization: Bearer your_jwt_token_here
Content-Type: application/json

{
  "title": "Updated Title",
  "description": "Updated description of the note."
}
```

### 6. Delete a Note

```bash
DELETE /notes/{id}
Authorization: Bearer your_jwt_token_here
```

## Application Properties

The **application.properties** file includes configuration for the MySQL database, server settings, and Hibernate configurations.

```properties
spring.application.name=NoteTaking
spring.datasource.url=jdbc:mysql://localhost:3306/noteapp
spring.datasource.username=root
spring.datasource.password=your_password_here
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
server.servlet.session.cookie.same-site=strict
```

## Dependencies

Here are the Maven dependencies used in the project:

### Main Dependencies

- **spring-boot-starter-data-jpa**: Provides support for JPA and Hibernate, which allows interaction with the MySQL database.
- **spring-boot-starter-security**: Implements Spring Security to secure the application and handle authentication and authorization.
- **spring-boot-starter-web**: Provides all the tools needed to develop RESTful APIs (including embedded Tomcat).
- **mysql-connector-j**: JDBC driver for connecting to MySQL database.
- **spring-boot-starter-test**: Provides testing support for Spring Boot applications.
- **spring-security-test**: Provides security test support to test secured endpoints.

### Full `pom.xml` dependencies section:

```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-test</artifactId>
    <scope>test</scope>
  </dependency>
</dependencies>
```

## Security

- The application uses **Spring Security** to authenticate users and restrict access to notes.
- User passwords are hashed using **BCryptPasswordEncoder** to ensure secure storage.
- JWT is used for stateless authentication.

## Contributing

Feel free to fork the repository and submit pull requests for enhancements, bug fixes, or new features!

## License

This project is licensed under the MIT License.
