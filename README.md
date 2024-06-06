# Survey Management System

## Introduction

This project is a survey management system designed to efficiently store and manage a bank of survey questions. It maintains the relationships between surveys, their questions, and the response options. This version focuses solely on the repository for surveys, questions, and response options, excluding the response module.

## Entity-Relationship Model

### Relationships between entities

- **User-Survey**: A user can create many surveys (one-to-many), and each survey is associated with a single user (many-to-one).
- **Survey-Question**: A survey can have many questions (one-to-many), and each question belongs to a single survey (many-to-one).
- **Question-OptionQuestion**: A question can have many options, and each option belongs to a single question.
- **Question-Answer**: A question can have many answers, and each answer is associated with a single question.
- **OptionQuestion-Answer**: An option can be selected in many answers, and each answer can be associated with a single option.

## Technologies Used

- Java
- Spring Boot
- GitHub
- Git
- MySQL
- Maven
- Swagger