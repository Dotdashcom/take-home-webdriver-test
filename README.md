# KevalDotDashTest
Installation and System Requirement for This Project:

(1)Windows 7 or higher Operating System
(2)JAVA SDK8 should be installed
(3)Latest version of Eclipse  

How to run “KevalDotDash” project  through Your Eclipse and Structure of Project
    
(1)Extract KevalDotDash into your C drive

(2)Import KevalDotDash in your Eclipse.

(3) Import necessary packages to run the project succefully.

(4)  under the KevalDotDash  project  I have created 2 packages.

(5) src/main/java it consists of all the packages such as base , config , pages , test data and util and under the src/test/java package it consists of all the testcases of implementation of page files.

(6) In TestBase class file it is the super class of all the class file which has driver initialization methods , set the browser properties and invoke the URL  and using the inheritance concept all the sub-class is taking the methods , variables and features of the parent class file.

(7)  config.properties file has username and password along with browser value.

(8) Under the pages package  BrowseData.java classfile it has all the WebElements and in testdata package it has BaseUrl.java file which has  all the URL paths  to hit the specific location .

(9)  In  src/test/java package it has testcases package under that all the  class file which implements all the test cases and extends the TestBase class also for proper invocation.

(10)  This is the Maven Project so it has pom.xml file which has all the dependencies of selenium webdriver and TestNG. I have implememted Page Object Model with Test Data Driven approach to run the test cases when it is necessary.

(11) To run the project click on testng.xml file and select TestNG suite to run all the testcases by single click  and output will display on console.





