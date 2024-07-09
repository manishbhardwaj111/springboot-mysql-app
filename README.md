# Spring Boot CRUD Operations with MySQL

This project demonstrates basic CRUD (Create, Read, Update, Delete) operations using Spring Boot and MySQL for managing Employee and Department entities.

## Technologies Used

- Java
- Spring Boot
- MySQL
- Maven (for dependency management)

## Setup Instructions

docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=emp-db -e MYSQL_USER=manish -e MYSQL_PASSWORD=manish -p 3306:3306 -d mysql:latest

### Prerequisites

- JDK 21 or later installed
- MySQL installed and running locally or on a server

### Steps to Run

1. **Clone the repository**

   ```bash
   git clone <repository-url>
   cd <repository-directory>
