# Book Store Backend


This project implements a backend API for a Book Store using Spring Boot. The objective is to simulate a real-world example of a robust and secure backend. It follows Clean Architecture principles to manage books, authors, and publishers, ensuring scalable and maintainable code.


## Features
- Database schemas and relations
- CRUD API operations for books, authors, and categories


## Technologies Used
- **Java 17**: The programming language used for the project.
- **Maven**: Dependency management and build tool.
- **Spring Boot**: Framework for building the backend application.
- **Spring Web**: Module for building web applications.
- **Spring Dev Tools**: Tools for improving developer productivity.
- **Spring Data JPA**: Abstraction layer for database operations.
- **H2 Database**: In-memory database used for development and testing.


## Struct
- **Controllers:** AuthorController, PublisherController, BookController
- **Entities:** Author, Book, Publisher
- **Repositories:** AuthorRepository, PublisherRepository, BookRepository
- **Services:** AuthorService, BookService, PublisherService
- **Enums:** Genre, Language
- **DTOs:** AuthorDto, BookDto, PublisherDto


## API Endpoints

### Book Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /book/   | List all books in the database |
| GET    | /book/{id} | Get information about the book with the specified ID |
| POST   | /book/   | Create a new book, following the BookDto structure |
| DELETE | /book/{id} | Delete the book with the specified ID |
| PUT    | /book/{id} | Update the book with the specified ID, following the BookDto structure |

### Author Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /author/   | List all authors in the database |
| GET    | /author/{id} | Get information about the author with the specified ID |
| POST   | /author/   | Create a new author, following the AuthorDto structure |
| DELETE | /author/{id} | **Not allowed** due to the relation with books |
| PUT    | /author/{id} | Update the author with the specified ID, following the AuthorDto structure |

### Publisher Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /publisher/   | List all publishers in the database |
| GET    | /publisher/{id} | Get information about the publisher with the specified ID |
| POST   | /publisher/   | Create a new publisher, following the PublisherDto structure |
| DELETE | /publisher/{id} | **Not allowed** due to the relation with books |
| PUT    | /publisher/{id} | Update the publisher with the specified ID, following the PublisherDto structure |



