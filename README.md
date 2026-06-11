
# Digital Document Verification System

## Overview

The Digital Document Verification System is a Java-based console application that manages document upload, officer assignment, verification status updates, and verification logs.

This project demonstrates core Java concepts such as object-oriented programming, encapsulation, service-layer design, collection handling, custom exception handling, and modular package structure.

## Features

* Add and manage users
* Upload documents for verification
* Assign officers to documents
* Update document verification status
* Maintain verification logs
* Generate document verification reports
* Handle invalid operations using custom exceptions

## Technologies Used

* Java
* Object-Oriented Programming
* Collections Framework
* Custom Exception Handling
* Modular Programming
* Eclipse IDE / VS Code

## Project Structure

```text
src/
└── com/
    └── wipro/
        └── ddvs/
            ├── Main.java
            ├── entity/
            │   ├── User.java
            │   ├── Document.java
            │   ├── Officer.java
            │   └── VerificationLog.java
            ├── service/
            │   └── VerificationService.java
            └── util/
                ├── UserNotFoundException.java
                ├── DocumentNotFoundException.java
                ├── OfficerNotFoundException.java
                └── InvalidVerificationException.java
```

## Core Modules

### Entity Layer

Contains model classes representing the main objects of the system:

* User
* Document
* Officer
* VerificationLog

### Service Layer

Contains business logic for:

* User validation
* Document upload
* Officer assignment
* Status updates
* Verification log generation
* Verification report creation

### Exception Layer

Contains custom exceptions for handling invalid operations:

* UserNotFoundException
* DocumentNotFoundException
* OfficerNotFoundException
* InvalidVerificationException

## Sample Workflow

1. A user is registered in the system.
2. The user uploads a document.
3. An officer is assigned to verify the document.
4. The officer adds a verification log.
5. The document status is updated.
6. A verification report is generated.

## Example Output

```text
VERIFICATION REPORT

Document ID: D001
File Name: marksheet.pdf
Document Type: Education Proof
Uploaded By: U001
Assigned Officer: O001
Current Status: VERIFIED

VERIFICATION LOGS

Log ID: L001
Officer ID: O001
Date: 2025-08-12
Notes: Verified marksheet, details match.
```

## Concepts Demonstrated

* Encapsulation
* Class and Object Design
* ArrayList-based data handling
* Service-layer architecture
* Custom exception handling
* Modular package organization
* Report generation using StringBuilder

## Future Enhancements

* Add JDBC and Oracle Database integration
* Add user login and authentication
* Store uploaded document metadata permanently
* Add admin dashboard
* Add file upload support
* Add document approval and rejection history
* Convert the console application into a web application

## Author

Vishal S R

