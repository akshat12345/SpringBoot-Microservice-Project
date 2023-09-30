# SpringBoot-Microservice-Project
Pharmacy Supply Management

This project is based on Java Spring Boot Microservice architecture. The project has multiple different services, which focus on managing various functionalities of the pharmacy supply system. 

Microservices Inside This Project - 
* Pharmacy Medicine Supply Portal - This is one of the most critical services in the project, as it focuses on communicating with all other services and managing the user interface of the entire system.
* Authorization Service - This service helps manage user-related data like (username, user ID, and password) and also validates the jwt token(generated at the time of login) when any two services are trying to communicate.
* Medicine Stock Service - This service communicates with the database, which stores the information about medicine stock. It helps other services by sharing information about the medicine stock.
* Pharmacy Supply Service - This service is for placing orders for a particular medicine. It communicates with the Medicine Stock Service.
* Medical Representative Schedule Service - This service is for scheduling an appointment with the Medical Representative.

Technology Stack - 
* Java 8
* Spring Boot 2.3.9
* Feign Client
* Swagger API
* MySQL
* H2 Database
* Docker/Docker Compose
