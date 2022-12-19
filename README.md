# Student Fee Management System

## Introduction
This project has implemented the CR operations in a simple way with H2 embedded database, custom exceptions and tests for controller class and service class.

Calls Student's core microservice to validate student is exist or now. 

## Features of this Project
- Create Fee(Student fee payment)
- Show all
- Find by ID (Student's fee receipt)
- Delete by ID

## Environment
- Eclipse IDE
- Java 11
- Spring
- Spring initializr
- H2 Embedded Database

## Operating Instructions
- Download source code and import into your code editor (Eclipse, IntelliJ..).
- The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies
- If there are no errors, run program.
- Use [Postman](https://www.postman.com) to check app or use tests.

## Testing
### URL : http://localhost:8081/v1/student/fee + 
- ## POST METHOD
- ### /add
Add student with this in body: <br/>
{ <br/>
    "cardNo": "124", <br/>
    "gradeId": "1", <br/>
    "cardType": "master", <br/>
    "feeAmt": 10.25, <br/>
    "studentId": 1, <br/>
}
- ## GET METHOD
- ### /all
List all Student's fee receipts from DB.

- ### /find/{id}
Find student's receipt in DB by ID.

