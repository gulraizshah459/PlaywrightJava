# Playwright Automation Framework

This project is a Playwright-based automation framework designed to test the website. It uses Java as the programming language, TestNG as the test runner, and Maven as the build tool.

## Prerequisites

* **JDK 11 or higher:** Ensure you have a compatible Java Development Kit installed.
* **Maven:**  Make sure Maven is installed and configured on your system.

## Project Structure

* **`src/test/java/com/Mercari/Tests`:** Contains the test cases (`SearchTest`).
* **`src/test/java/com/Mercari/Pages`:** Contains the page object classes (`SearchPageRepo`).
* **`src/test/resources`:**
    * **`config`:** Holds the `config.properties` file for configuration settings.
    * **`testRunners`:** Contains the `testng.xml` file for defining test suites.
* **`src/main/java`:**  Contains the driver factory class (`PlaywrightBrowserManager`) and utility functions (`CommonFunctions`).

## Framework Overview

* **Playwright:** A modern automation framework for web testing, chosen for its speed, reliability, and cross-browser support.
* **Java:** The programming language used for writing test scripts.
* **TestNG:**  A testing framework for organizing and running tests, providing features like annotations, reporting, and parallel execution.
* **Maven:** A build automation tool for managing dependencies and the project lifecycle.
* **Page Object Model (POM):** The framework follows the POM design pattern to enhance code organization and maintainability. The `SearchPageRepo` class encapsulates page elements and actions for the Mercari search page.
* **Driver Factory:** The `PlaywrightBrowserManager` class handles the initialization and configuration of the Playwright driver, including browser selection and viewport size.
* **Utility Functions:** The `CommonFunctions` class provides reusable utility functions for waiting for elements to be displayed or selected.
* **Configuration:**  The `config.properties` file stores configuration settings like the browser to use and the base URL of the application.

## Running the Tests

1. **Clone the repository:** `git clone https://github.com/gulraizshah459/PlaywrightJava.git`
2. **Navigate to the project directory:** `cd <project_directory>`
3. **Execute the tests:** `mvn clean test`

This will run the tests defined in the `testng.xml` file. You can modify `testng.xml` to include or exclude specific tests or to run tests in parallel.


## Additional Notes

* The framework is designed to be extensible and can be easily adapted to test other areas of the Mercari website or other web applications.
* Consider adding more robust reporting (e.g., using ExtentReports or Allure) for enhanced test analysis and visualization.
* You can configure the framework to run tests in headless mode by modifying the `config.properties` file.
* Refer to the Playwright documentation for more advanced features and capabilities.