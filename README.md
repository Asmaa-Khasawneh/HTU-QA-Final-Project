# Loyalty+ Store – Software Testing & QA Project

## Project Overview
This project represents a complete Quality Assurance testing portfolio for a retail platform scenario (Loyalty+ Store).
The work includes manual testing and automated testing to ensure the functionality, reliability, and performance of the system.

Manual and UI automation testing were conducted on the web application (SauceDemo), while API functional testing and API performance testing were performed on the DummyJSON REST API using Postman, Newman, and k6.
The main objective of this project is to validate core system functionality, identify defects, and evaluate API performance under different load conditions.

## Project Scope
The scope of this project focuses on validating the functional and non-functional aspects of a retail web application and its supporting REST APIs.
Testing activities were designed to ensure core features work as expected, defects are identified, and API performance meets acceptable quality standards.

### In Scope
- Manual functional testing of core web application features.
- UI automation testing for critical user flows using Selenium.
- API functional testing using Postman with automated assertions.
- API performance testing using k6 under different load profiles.
- Defect reporting with execution evidence.
- Test documentation and reporting.

### Out of Scope
- Database testing and data integrity validation.
- Security testing (penetration testing, vulnerability scanning).
- Testing with real user or payment data.
- Production environment testing.

## Setup and Preparation
The project setup includes the required tools and environments needed to execute manual testing, API testing, performance testing, and UI automation.
All tools were configured locally to ensure consistent and repeatable test execution.

### Manual Testing Setup
For manual testing activities, the only required setup was access to the web application under test.
The website was used directly through a web browser to execute test scenarios.

Microsoft Excel was used to document manual test cases, test execution results, and bug reports.
No additional tools or configurations were required for manual testing.

### API Testing Setup (Postman & Newman)
Postman was used to perform functional API testing on the DummyJSON public REST API.
Within Postman, collections and environment files were created to organize requests, manage variables, and handle authentication data.

Data-driven testing was implemented using CSV files to execute multiple test iterations with different input values.
Newman was used as a command-line tool to run Postman collections and generate automated execution reports in HTML format.

### API Performance Testing Setup (k6)
API performance testing was conducted using k6.
The Postman API collection, environment configuration, and data-driven CSV files were reused to maintain consistency between functional and performance testing.

Node.js was installed to support the required performance testing tooling.
A conversion tool was used to transform the Postman collection into k6-compatible scripts.
k6 was executed via the command line to run performance tests and collect performance metrics and results.

### UI Automation Setup
UI automation testing was implemented using Selenium WebDriver with Java.
Eclipse IDE was used to develop the automation framework.

A new Java project was created and then converted into a Maven project by configuring the `pom.xml` file.
Required Maven dependencies, including Selenium and TestNG, were added to manage libraries and test execution.

TestNG was used as the testing framework to structure and execute automated test cases.
The Maven project structure was used to ensure maintainability and ease of execution.

## How to Run Tests
This section describes how to execute all test cases implemented in this project.
It explains the required steps to run API tests, performance tests, and UI automation tests using the corresponding tools and configurations.

### Run API Tests Using Postman
1. Open Postman.
2. Import the Postman collection.
3. Import the Postman environment file.
4. Select the correct environment from the environment dropdown.
5. Open the collection and click on **Run Collection**.
6. Attach the CSV file used for data-driven testing in the Collection Runner.
7. Start the run and review the execution results inside Postman.

### Run API Tests Using Newman
1. Export the Postman collection file.
2. Export the Postman environment file.
3. Place the collection file, environment file, and CSV data file in the same folder.
4. Open Command Prompt (CMD) in that folder.
5. Run the following command:

   newman run collection.json -e environment.json -d data.csv -r html

6. After execution, an HTML report will be generated in the same folder.

### Run API Performance Tests Using k6
The k6 performance test script is already prepared and included in the repository.

1. Navigate to the `04-API-Performance-k6` folder.
2. Open Command Prompt (CMD) in that folder.
3. Run the following command:

   k6 run K6Script.js

4. Review the performance results displayed in the command line output.

### Run UI Automation Tests
1. Clone or download the project from GitHub.
2. Open Eclipse IDE.
3. Import the project into Eclipse as an existing Maven project.
4. Wait for Maven dependencies to be downloaded and resolved.
5. Navigate to the TestNG test suite file.
6. Right-click on the test suite and select **Run As → TestNG Suite**.
7. Review the test execution results in the Eclipse console.

## Where to Find Evidence and Reports

This section provides the locations of all test evidence, execution results, and reports generated during the testing activities.
Screenshots, logs, and reports are organized by testing type within the project folders for easy access and review.

### Manual Testing Evidence
Manual testing artifacts are available in the `02-Manual-Testing` folder.
The folder contains an Excel file with two sheets: one for manual test cases and another for bug reports.
All execution screenshots and supporting evidence are linked directly within the Excel file.

### API Testing Evidence
API testing artifacts are available in the `03-API-Postman` folder.
Inside this folder, a `Newman` subfolder contains the HTML report generated from the Newman execution.
An additional README file is included in the API folder, providing details about the API testing approach and execution.

### API Performance Testing Evidence
API performance testing artifacts are available in the `04-API-Performance-k6` folder.
This folder contains a Word document titled `K6 Analysis`, which includes execution screenshots, performance results, and detailed analysis for each test case and load profile.
A README file is also included in the folder to provide additional details related to the performance test cases.

### UI Automation Evidence
UI automation testing evidence is available in the `05-UI-Automation` folder.
This folder contains a Word document that includes execution screenshots, a recorded run video, test results, and analysis of the automated tests.
A README file is also included to provide additional details about the UI automation evidence.

### Final Project Report
The complete project report is available in the `06-Report` folder.
This folder contains the final technical report titled `FinalReport-Asmaa-Khasawneh`, which provides a comprehensive overview of the project, including testing strategy, execution summary, results, analysis, and conclusions.





