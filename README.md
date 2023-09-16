# Workshop - Springboot3 MongoDB

This project was developed as a workshop during the *"Java COMPLETO 2023 Programação Orientada a Objetos + Projetos"* course by Professor Nelio Alves, available on [Udemy](https://www.udemy.com/course/java-curso-completo/).

It was created as a platform for testing and experimenting with Spring Boot, alongside other tools such as Maven and Rest. This application implements a CRUD system for managing users, posts, and comments, simulating a highly simplified social media platform.

# Setting it up

Before doing anything, make sure you have all the requirements installed on your machine.

Open the command prompt (cmd) and run `mongod` to start MongoDB.

Next, open Spring Tool Suite and import the project.
Navigate to `\src\main\resources`, and open the `application-test.properties` file.
Look for the uri. This is the address we will use to establish a connection with MongoDB.
You can either copy this URI or modify it if you are familiar with the configuration.

Open MongoDB Compass and initiate a new connection using the copied URI, but remove the end part so it appears as `mongodb://localhost:27017/`. The part you removed will be the database name.
Establish the connection and create a new database with the same name you removed, which is `workshop_mongo` in this project.
Within this database, create two collections named `user` and `post`. These collections will store your data. Initially, they will be empty until you run the application for the first time, generating then some mock data.

To run the application, simply execute it as a Spring Boot App.

If you have Postman installed, you can perform web requests, such as GET, SET, PUT, and DELETE (CRUD) operations.

As mentioned earlier, the CRUD operations are configured and ready to use. If any exceptions occur during these operations, the Spring Boot App console will provide alerts.

# Requirements

To run this project, it's necessary to have Java 17 (LTS) installed on your machine. The Java version I used was Java Azul Zulu 17.0.7 (LTS) ([link](https://www.azul.com/downloads/?version=java-17-lts&package=jdk#zulu)), but it should not be necessary to have this exact version for the project to work.

Furthermore, you will need **Spring Tool Suit** ([link](https://spring.io/tools)) to run the project.

For the database, you will need **MongoDB** ([link]([https://www.apachefriends.org/download.html](https://www.mongodb.com/try/download/community))) and **MongoDB Compass**, which can be installed in the same installer as MongoDB.

To simulate web requests, you can use **Postman** ([link](https://www.postman.com/downloads/)), although this is optional.

##

Created by @AlysonCantalice.
