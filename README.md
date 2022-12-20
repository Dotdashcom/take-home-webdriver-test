# Selenium & Cucumber

This test suite is a  POM, BDD Java test automation framework. Built on RestAssured Library and Cucumber.

## Prerequisites

To use this project, you'll need:
- Java Runtime Environment (JRE) or a Java Development Kit (JDK) version 8 or later
- Maven


### Execution

run the "src/test/java/com/dotdash/runners/CukesRunner.java" class
- run command with test report
- mvn verify -Dcucumber.options="--tags @regression"


### Folder structure

- features - This folder contains all `.feature` files with test steps
- stepDefinitions - This folder contains the required implementation files
- runners - This folder contains the runner class
- reports are in the target/cucumber_html-reports