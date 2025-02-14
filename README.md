# Agile-Software-Development-Project
This project is an Agile Software Development-based banking application. It follows iterative development cycles to build, test, and deploy features for managing user accounts, transactions, and balance inquiries. The app provides a secure and user-friendly interface for handling financial operations

# Agile Software Development: Banking App Test Suite Assignment 2024

Author: Sharon P Garapati

Email: G00438803@atu.ie

 Overview

This repository contains the Junit5-based automated test suit for the “Banking Application” (banking.java) in Agile Software Development. The project involves refactoring the provided `banking.java` application and developing a comprehensive JUnit 5 test suite that covers every method, including tests for two exception types.

Requirements

- Refactoring: The original banking application has been refactored (by adding/removing methods or reorganizing classes) to improve testability.
  
- JUnit 5 Test Suite:
  
  - Utilizes annotations: `@BeforeAll`, `@BeforeEach`, `@Test`, `@ParameterizedTest`, `@Timeout`, `@AfterAll`, and `@AfterEach`.
    
  - Tests every method in the refactored code.
    
  - Includes tests for two different exceptions.
    
- Agile Development: The project was developed iteratively with continuous integration and testing.
  

Project Structure

. ├── src │ ├── banking.java # Original application (refactored as needed) │ └── RefactoredBanking.java # Refactored version for improved testability └── test └── BankingTestSuite.java # JUnit 5 test suite for the banking app


How to Run the Tests

1. Compile the Code:
   
   Ensure you have Java (JDK 8 or higher) and JUnit 5 available. Compile the refactored source code:
   ```bash
   
   javac -d bin src/RefactoredBanking.java

   
2.	Compile the Test Suite:
 
3.	javac -cp.: junit-platform-console-standalone-1.8.2.jar -d bin test/BankingTestSuite.java
   
4.	Run the Tests:
   
Use the JUnit Platform Console Launcher: 

5.	java -jar junit-platform-console-standalone-1.8.2.jar --class-path bin --scan-class-path

   
Learning Outcomes

This assignment demonstrates:

•	The ability to refactor legacy code for testability.

•	Proficiency in designing and implementing comprehensive automated tests with JUnit 5.

•	Application of Agile principles throughout the software development life cycle.

•	Effective project management and iterative development practices.


License

This project is licensed under the MIT License.

