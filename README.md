# Dotdashcom automation challenge

![CI/CD Badge](https://github.com/MateusPasqualini/take-home-webdriver-test/workflows/Java%20CI%20with%20Maven/badge.svg)

## Required software

* [Java JDK 8+](https://jdk.java.net/java-se-ri/8-MR3)
* [Maven](https://maven.apache.org/download.cgi)

## Running the tests

### Running the test suites locally

to run the suite simply run the maven test lifecycle

```
mvn -DdriverClass=<DRIVER-CLASS> -Dbrowser=<BROWSER> clean test
```

Where: ``<DRIVER-CLASS>`` is the variable for the driver installation.
And ``<BROWSER>`` is the variable for choosing the browser to launch

Running on Chrome: ``mvn -DdriverClass=ChromeDriver -Dbrowser=chrome clean test`` would run the tests on Chrome browser

Running on Firefox: ``mvn -DdriverClass=FirefoxDriver -Dbrowser=firefox clean test`` would run the tests on Chrome
browser

Running through the IDE: Run the test by right-click on the TestNG XML file

* For IntelliJ: Select ``Run '...\testng.xml' ``
* For Eclipse: Select ``Run As => TestNG Suite.``

### Generating the test report

there are two ways to generate the reports:

* `mvn allure:serve`: will open the HTML report into the browser (it will run on a local port. default:52608)
* `mvn allure:report`: will generate the HTML port at `target/site/allure-maven-plugin` folder

## Libraries

* [Selenium WebDriver](https://www.selenium.dev/) library for automating web-based applications
* [TestNG](https://testng.org/doc/) to support the test creation
* [Allure Report](https://docs.qameta.io/allure/) as the testing report strategy
* [Hamcrest](http://hamcrest.org/) for more flexible and readable assertions

## Patterns applied

* Page Objects
* Page Factory
* Page Generator
* Base Test

## Pipeline

This project uses [GitHub Actions](https://github.com/features/actions) to run the all the tests in a pipeline.

In this project the workflow goes as this:

```
build -> end to end tests -> collect allure rerport -> deploy to github pages
```

to the trigger the CI/CD, it can be either done with push to the main branch or pull request to the main branch also. It
can also be triggered manually, by going into the Actions tab, entering an existing workflow and re-running it.

To be able to successfully run the pipelines there is the need to set a GitHub token for access the instructions can be
found
here: [GitHub Token instructions](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)
