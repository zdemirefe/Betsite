# Betsite

## About the Project
Betsite is a modern, user-friendly web application for sports betting.  
It provides a REST API built with Spring Boot backend and an interactive frontend developed in React.js.  
The application uses MySQL for secure and efficient data management.

---

## Features

- User registration and login  
- Listing and viewing sports events  
- Managing betting odds  
- Creating and tracking bet slips  
- Payment processing  
- User statistics and analytics  
- Responsive, fast, and modern React-based frontend

---

## Technologies Used

- Backend: Java 17, Spring Boot 3.2  
- Frontend: React.js  
- Database: MySQL  
- ORM: Spring Data JPA  
- API Documentation: springdoc-openapi  
- Other libraries: Lombok, ModelMapper, Semantic UI React, Formik, Yup

---

## Setup Instructions

### Backend
1. Create a MySQL database and configure the connection in `application.properties`.  
2. Build the project and download dependencies with Maven:  
   ```bash
   mvn clean install

!!!!!!! React 18 needed for this project. !!!!!!!!! 
!!!!!!! Lombok must inject manually if you using Eclips IDE !!!!!!!

