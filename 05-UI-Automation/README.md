# UI Automation – Selenium

## Overview
This section of the project focuses on automated UI functional testing.
The UI automation tests are implemented using Selenium WebDriver with Java
and TestNG, and the project is structured as a Maven project developed using
the Eclipse IDE.

The tests are designed to validate critical user workflows on the SauceDemo
web application, such as login, product selection, cart operations, and checkout.

## Prerequisites
To run the UI automation tests, the following tools and software are required:

- Java JDK installed and properly configured
- Eclipse IDE
- Maven (used for project build and dependency management)
- TestNG framework
- Selenium WebDriver libraries
- Google Chrome browser
- ChromeDriver compatible with the installed Chrome version

## Project Structure
The UI automation project follows a Maven-based structure with a clear separation
between test logic and test data.

- src/ui.data  
  Contains test data classes used for different user scenarios, such as standard,
  problem, and error users.

- src/ui.tests  
  Contains the automated test classes implemented using Selenium and TestNG.
  This package includes the base test setup and individual test classes for
  login and user-specific scenarios.

- pom.xml  
  Manages project dependencies and build configuration, including Selenium
  WebDriver and TestNG.

- testng.xml  
  Defines the TestNG test suite configuration and execution order.

- test-output / target  
  Automatically generated folders that contain execution results and build artifacts.

## How to Run the Tests
The UI automation tests can be executed using TestNG in two different ways:

### Option 1: Run tests from the source folder
1. Right-click on the `src` folder or on a specific test class.
2. Select **Run As** → **TestNG Test**.

Running the tests this way may launch multiple browser instances, as multiple
test classes can be executed in parallel.

### Option 2: Run tests using testng.xml (Recommended)
1. Right-click on the `testng.xml` file.
2. Select **Run As** → **TestNG Suite**.

This approach runs the predefined TestNG suite and executes the tests in a
controlled order, typically using a single browser instance.

## Test Coverage
The UI automation tests cover different user types supported by the SauceDemo
application to validate system behavior under various conditions.

- Standard user scenarios, including successful login and normal application flow
- Problem user scenarios to verify system behavior when UI issues are present
- Error user scenarios to validate error handling and incorrect behavior
- Performance user login scenario to validate delayed login behavior
- Blocked user login scenario to validate access restriction and error messages

Some user types, such as the performance and blocked users, are validated only
at the login level due to system limitations, as further application flow is not
accessible for these users.

## Notes and Limitations
- The SauceDemo application is a demo system, and its behavior and test data
  are predefined and cannot be modified.
- Some user types, such as blocked and performance users, have limited access
  within the application, which restricts test coverage beyond the login stage.
- Test data used in the UI automation is static and based on the predefined
  users provided by the SauceDemo system.
