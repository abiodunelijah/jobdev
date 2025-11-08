# JobDev - Job Portal Application

A modern job portal REST API built with Spring Boot that enables users to browse job listings and apply for positions. The application provides a clean architecture for managing job postings and applications.


## ✨ Features

- **Job Management**
  - Create, read, update, and delete job postings
  - View all available jobs
  - Get detailed job information

- **Application System**
  - Users can apply for jobs
  - Track job applications
  - Link users to their applications

- **User Management**
  - Support for local and OAuth authentication providers (Google)
  - Role-based system (Admin, Applicant)
  - Secure user data handling

- **Exception Handling**
  - Global exception handling
  - Custom error responses
  - Resource not found handling

## 🛠 Tech Stack

- **Backend Framework**: Spring Boot 3.5.4
- **Language**: Java 25
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA / Hibernate
- **Build Tool**: Maven
- **Additional Libraries**:
  - Lombok (Code generation)
  - Spring Boot DevTools (Development utilities)
  - Jackson (JSON processing)

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

- Java 25 or higher
- Maven 3.x
- PostgreSQL 12 or higher
- Your favorite IDE (IntelliJ IDEA recommended)

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd jobdev
   ```

2. **Set up PostgreSQL database**
   ```sql
   CREATE DATABASE devjob;
   ```

3. **Configure database credentials**
   
   Update `src/main/resources/application.yaml` with your PostgreSQL credentials:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/devjob
       username: your_username
       password: your_password
   ```

4. **Build the project**
   ```bash
   cd jobdev
   ./mvnw clean install
   ```

## ⚙️ Configuration

The application uses YAML configuration located at `jobdev/src/main/resources/application.yaml`:

```yaml
spring:
  application:
    name: jobdev
  
  datasource:
    url: jdbc:postgresql://localhost:5432/devjob
    username: postgres
    password: your_password
    driver-class-name: org.postgresql.Driver
  
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
        show_sql: true
```

**Note**: Set `ddl-auto: validate` in production environments.

## 🔌 API Endpoints

### Job Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/jobs` | Create a new job |
| GET | `/api/jobs` | Get all jobs |
| GET | `/api/jobs/{id}` | Get job by ID |
| PUT | `/api/jobs/{id}` | Update a job |
| DELETE | `/api/jobs/{id}` | Delete a job |

### Application Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/applications/apply/{userId}/{jobId}` | Apply for a job |

### Example Requests

**Create a Job**
```http
POST http://localhost:8080/api/jobs
Content-Type: application/json

{
  "title": "Springboot Dev",
  "description": "Spring framework Dev with 3 years",
  "company": "Banking"
}
```

**Apply for a Job**
```http
POST http://localhost:8080/api/applications/apply/1/5
```

**Get All Jobs**
```http
GET http://localhost:8080/api/jobs
Accept: application/json
```

## 🗄️ Database Schema

### Tables

**users**
- `id` (Primary Key)
- `name`
- `email` (Unique)
- `password` (Nullable for OAuth users)
- `auth_provider` (LOCAL, GOOGLE)
- `role` (APPLICANT, ADMIN)

**jobs**
- `id` (Primary Key)
- `title`
- `description`
- `company`
- `posted_date`

**applications**
- `id` (Primary Key)
- `user_id` (Foreign Key → users)
- `job_id` (Foreign Key → jobs)

## 🏃 Running the Application

### Using Maven Wrapper

```bash
cd jobdev
./mvnw spring-boot:run
```

### Using Maven

```bash
cd jobdev
mvn spring-boot:run
```

### Using Java

```bash
cd jobdev
./mvnw clean package
java -jar target/jobdev-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

## 📁 Project Structure

```
jobdev/
├── src/
│   ├── main/
│   │   ├── java/com/coder2client/
│   │   │   ├── controller/        # REST Controllers
│   │   │   ├── dtos/              # Data Transfer Objects
│   │   │   ├── entity/            # JPA Entities
│   │   │   ├── enums/             # Enumerations
│   │   │   ├── exception/         # Exception handling
│   │   │   ├── mapper/            # Entity-DTO mappers
│   │   │   ├── repository/        # JPA Repositories
│   │   │   ├── service/           # Business logic
│   │   │   └── JobdevApplication.java
│   │   └── resources/
│   │       └── application.yaml   # Configuration
│   └── test/                      # Test files
├── pom.xml                        # Maven configuration
└── README.md
```

## 🏗️ Architecture

The application follows a layered architecture:

- **Controller Layer**: Handles HTTP requests and responses
- **Service Layer**: Contains business logic
- **Repository Layer**: Data access layer using Spring Data JPA
- **Entity Layer**: Domain models
- **DTO Layer**: Data transfer objects for API communication
- **Mapper Layer**: Converts between entities and DTOs


**Happy Coding! 🚀**
