# Spring Boot CRUD Operations with MySQL

This project demonstrates basic CRUD (Create, Read, Update, Delete) operations using Spring Boot and MySQL for managing Employee and Department entities.

## Technologies Used

- Java
- Spring Boot
- MySQL
- Maven (for dependency management)

## Setup Instructions

### Prerequisites

- JDK 17 or later installed
- Docker installed and running

### Docker Setup for MySQL

1. **Run MySQL Docker Container**

   Run the following command to start a MySQL Docker container with necessary environment variables:

   ```bash
   docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=emp-db -e MYSQL_USER=manish -e MYSQL_PASSWORD=manish -p 3306:3306 -d mysql:latest
