# CaliforniaEnergyCommission

This project is a Java-based UI test automation framework built with [Playwright](https://playwright.dev/java/). It automates form workflows and UI validations for the California Energy Commission system. The test framework is designed to validate various form types, dashboard behavior, and user interactions using 30 structured test suites.

Currently, **Test Suite 1** is fully implemented and serves as the foundation for further automation coverage with having the client permission to show the first test case.

---

## Technologies Used

* Java 17+
* Playwright for Java
* TestNG
* Maven
* TestNG Reporting
* Page Object Model (POM) Design Pattern

---

## Test Suite 1 – Overview

Source folder:
[`src/test/java/FirstTestSuit`](https://github.com/Ruhanyat-994/CaliforniaEnergyCommission/tree/main/src/test/java/FirstTestSuit)

### Structure and Responsibilities

| Folder                                                                                                                       | Purpose                                                                                                                     |
| ---------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- |
| [`base/`](https://github.com/Ruhanyat-994/CaliforniaEnergyCommission/tree/main/src/test/java/FirstTestSuit/base)             | Contains `BaseTest.java`, which sets up and tears down the Playwright browser context.                                      |
| [`pages/`](https://github.com/Ruhanyat-994/CaliforniaEnergyCommission/tree/main/src/test/java/FirstTestSuit/pages)           | Page Object Model classes like `LoginPage.java` and `DashboardPage.java` encapsulate UI logic and selectors.                |
| [`Data/`](https://github.com/Ruhanyat-994/CaliforniaEnergyCommission/tree/main/src/test/java/FirstTestSuit/Data)             | Contains data input classes for each test case, used to populate form fields dynamically.                                   |
| [`Assertions/`](https://github.com/Ruhanyat-994/CaliforniaEnergyCommission/tree/main/src/test/java/FirstTestSuit/Assertions) | Holds assertion logic to verify expected behavior after test steps are executed.                                            |
| [`test/`](https://github.com/Ruhanyat-994/CaliforniaEnergyCommission/tree/main/src/test/java/FirstTestSuit/test)             | Contains actual test classes like `CF1RALT02E_Test.java` and `CF2RMCH01BE_Test.java` that orchestrate end-to-end scenarios. |

---

## Running the Tests

Ensure you have Java and Maven installed. Then:

```bash
mvn clean install
mvn test -DsuiteXmlFile=testng.xml
```

This runs the defined tests using the TestNG suite file.

---

## Reporting

After execution, detailed test reports are generated in:

```
target/surefire-reports/
```

Key files:

* `emailable-report.html`: Clean summary of test results.
* `index.html`: Interactive report with step details.
* `Playwright Suite/`: Additional method-based reporting via TestNG.

