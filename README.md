# CollabSpace Document Service 

# Document Collaboration Service

This is the backend for the document collaboration platform I’m building. The goal is to allow users to create, share, and edit documents collaboratively in real-time. Eventually, it will support comments, whiteboard collaboration, file organization, and analytics.

## Current File Structure

<pre>
collab-space/
├── src/
│   ├── main/
│   │   ├── java/com/collabdoc/documentservice/
│   │   │   ├── controller/
│   │   │   │   └── DocumentController.java
│   │   │   ├── service/
│   │   │   │   ├── DocumentService.java
│   │   │   │   └── impl/
│   │   │   │       └── DocumentServiceImpl.java
│   │   │   ├── repository/
│   │   │   │   └── DocumentRepository.java
│   │   │   ├── model/
│   │   │   │   └── Document.java
│   │   │   ├── exception/
│   │   │   │   ├── DocumentNotFoundException.java
│   │   │   │   └── GlobalExceptionHandler.java
│   │   │   └── CollabSpaceApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── logback-spring.xml       
│
│   ├── test/
│   │   └── java/com/collabdoc/documentservice/
│   │       ├── service/
│   │       │   └── DocumentServiceImplTest.java
│   │       └── CollabSpaceApplicationTests.java
│
├── target/                   
├── pom.xml
├── README.md
├── .gitignore
├── jacoco-report/           
</pre>

## Features

- Create, retrieve, and manage documents
- REST API with structured request/response
- Exception handling with global error handler
- Logging for service operations
- Unit tests for services and controller
- Code coverage report using JaCoCo
  
## Technologies Used

- Java, J2EE
- Spring Boot & Spring Framework
- REST APIs (Spring Web)
- MySQL (SQL database)
- Maven (build tool)
- JUnit 5 & Mockito (unit testing)
- JaCoCo (code coverage)
- SLF4J + Logback (logging)
- ReactJS (frontend, separate repo/module)
- Kafka & GraphQL (planned)

### Prerequisites

- Java 17+
- Maven 3.8+
- MySQL 8.x (or higher)
- Git

---

## Setup Instructions

Make sure MySQL is running locally on port 3306 and create a new database:

```sql
CREATE DATABASE collabdoc;
```

Then update the following fields in `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/collabdoc
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## Running the App

Build and run:

```
mvn clean install
mvn spring-boot:run
```

The app will start on `http://localhost:8080`.

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/collab-space.git
cd collab-space
```
## API Plan

For now, REST APIs are being created to handle:

- Create document
- Read document by ID
- List all documents
- Update document
- Delete document

These are available under `/api/documents`.

## To Do (Upcoming Work)
- Create frontend 
- Unit testing 
- Create collaboration framework
- Set up deployment using Docker and AWS

## Notes

Using VS Code to develop. Avoiding any platform-specific IDE files and keeping it clean for GitHub.


---

This README will be updated regularly as the project progresses.
