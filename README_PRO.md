<<<<<<< HEAD
[![N|Solid](https://www.bobit.us/images/bobit-logo.png)](https://bobit37.github.io/Resume/)

# WebdriverTestCases

## Prerequisites

- Docker
- Git
- Java
- Selenium WebDriver
- Chrome Driver
- IDE

## Steps

- URL

https://github.com/Dotdashcom/take-home-webdriver-test

- Pull Docker image for the-internet app:
```
docker pull gprestes/the-internet
```
- Run the following command:
```
docker run -d -p 7080:5000 gprestes/the-internet
```
- Set the following BaseUrl for your tests:
```
http://localhost:7080
```
## URLs

- Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
- Login Failure: http://localhost:7080/login Login fail invalid creadentials
- CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes 
- ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'. Test JavaScript alert text on Right-Click.
- Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test. 
- Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
- Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload. 
- Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
- Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.
- File Download: http://localhost:7080/download Test File Download.
- File Upload: http://localhost:7080/upload Test File Upload.
- Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
- Iframe: http://localhost:7080/iframe Test iframe.
- Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
- JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
- JavaScript Error: http://localhost:7080/javascript_error Test JS error.
- Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
- Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.

## About this project

- This project has been created Page Object Model (POM) approach using Maven and TestNG.
- Allure report, extent report can be generated.
- Screenshot listener is cretaed to take screentshot if test case is failed. In framework target > surefire-reports > failure_screenshots
- Another taking screenshot is put in Allure listener. Project > screenthots
- All log files are stored in logs folder > application.properties.
- This framework is compatible with parallel execution and just configure in testng_runner.xml
- Apache POI jar is added for parameterized testing and excelutil is created to read data from excel sheet. In LoginPageTest class, invalid credentials test case is created using parameterized approach and all data is got from excel data file.

## Local usage: Clone framework 

- To use framework, copy https://github.com/BobIT37/WebdriverTestCases.git and clone in Eclipse or Intellij IDEA

## Using command line
## Specify project path on the terminal
- cd project_path

## to execute all test cases in a class
```
mvn -Dtest=LoginPageTest test

```


## to execute specific test method in a class
```
mvn -Dtest=LoginPageTest#testPageTitleTest test
mvn -Dtest=LoginPageTest#testLoginValidCreds test
mvn -Dtest=LoginPageTest#testLoginInvalidCreds test

```
## If you get compilation error when you execute it on terminal

- Find following plugin in POM.xml

```
 <plugin>
	<artifactId>maven-compiler-plugin</artifactId>
	<version>3.7.0</version>
	<configuration>
		<source>1.8</source>
		<target>1.8</target>
	</configuration>
 </plugin>
```
- past following plugin instead of previuos one

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
	<source>1.8</source>
	<target>1.8</target>
    </configuration>
</plugin>
```
- java: package org.testng does not exist ---> If you have this error on the console, delete test scope from TestNG dependencies
```
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>6.14.3</version>
    <scope>test</scope>
</dependency>
```	
- delete test scope line
	
## without command line
- go to test resources and find runner package, then execute testngrunner.xml file

# Reports

## Extent Report
https://bobit37.github.io/extentreport/

## Emailable HTML Report
https://bobit37.github.io/htmlreport/

## Allure Report
- cd project path
- run command: allure serve allure-results

