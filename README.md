# Tasks: Hexagonal Architecture

This project is designed to practice hexagonal architecture principles, emphasizing Clean Code. It serves as a task management system where users can create, read, update, and delete tasks through GET, POST, PUT, and DELETE requests.

## Prerequisites

To run this project, make sure you have the following installed:
- Java JDK 17
- Gradle 
- IntelliJ IDEA (recommended IDE for compiling and running the project)
- Database already configured and accessible

## Initial Configuration

### Database

It is necessary to have a database named `tasks` already created in your choice of database management system in the file `application.local.properties` is the initial set up

### Property File

This project uses a file named `application.local.properties` for local configuration, you need to change the file name `application.properties`.

## Installation

To install and run this project, follow these steps:

1. Clone the repository: ```https://github.com/AmyLovelace/hexagonal-arquitecture-spring.git```
2. Open the project with IntelliJ IDEA to facilitate its management through Gradle.
3. Configure the `application.properties` file with the necessary parameters (e.g., connection details for the database).

## Execution

To run the application:
1. Ensure that Gradle is configured as the build system in IntelliJ IDEA.
2. Run the project. The application should be available at `http://localhost:8080`.


## Contribution

If you would like to contribute to this project, please consider the following:
- Fork the repository.
- Create a branch for your changes.
- Submit a pull request for your changes to be considered.


## Authors

- [Amy Lovelace](https://github.com/AmyLovelace)