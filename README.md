# Webdriver Tests by JP

## Prerequisites
* Docker
+ Git
- Java
* Webdriver
+ ChromeDriver
* IDE such as IntelliJ

## Installation
There's easy way:
```
chmod +x setup.sh
chmod +x run.sh
./run.sh
```

And the other way

1. Pull Docker images for the-internet app:
   ```
   docker pull gprestes/the-internet
   ```

2. Inside the project's root folder type:

   ```
   mvn clean install -f pom.xml -DskipTests
   ```

3. (Optional) In case you don't have a Linux of Mac where to run this code, you can configure the suite to run against a dockerized selenium grid running linux. 

5. (Optional) To do this, open the testng.xml file inside your project's root and do the following change:

   ```
   <!-- <parameter name="environment" value="local"/> -->
   <parameter name="remote" value="http://localhost:4445/wd/hub"/>
   ```
To this:
   ```
   <parameter name="environment" value="local"/>
   <!-- <parameter name="remote" value="http://localhost:4445/wd/hub"/> --> 
   ```
5. (Optional) Also, take a look at the thread-count configuration in your testng.xml file, it may be useful:

   ```
   parallel = "tests" thread-count = "3">
   ```

4. (Optional) Then install the container like this:
   ```
   docker pull selenium/standalone-chrome
   ```

## Running
1. Run the following commands. The second one is optional.
   ```
   docker run -d -p 7080:5000 gprestes/the-internet
   docker run -d -p 4445:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome
   ```

2. Use the following BaseUrl for your tests:

   ```
   http://localhost:7080
   ```

   * (Optional) for you Selenium Grid:
   ```
   http://localhost:4445/wd/hub
   ```
      

3. To install the project, go to the project's root folder, and run:
   ```
   mvn clean install -f pom.xml -DskipTests
   ```   
4. To run the suite run:
   ```
   mvn test -DsuiteXmlFile=testng.xml
   ```
# Stopping
To stop the docker containers, run:
   ```
   docker stop "$(docker ps -q --filter ancestor=gprestes/the-internet)"
   docker stop "$(docker ps -q --filter selenium/standalone-chrome)"
   ```

## TestSuite structure
1. Use ChromeDriver to write Tests for the following scenarios in Java:
    * Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
    + Login Failure: http://localhost:7080/login Login fail invalid creadentials
    - CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
    * ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'. Test JavaScript alert text on Right-Click.
    + Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.
    - Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
    * Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.
    + Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
    - Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.
    * File Download: http://localhost:7080/download Test File Download.
    + File Upload: http://localhost:7080/upload Test File Upload.
    - Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
    * Iframe: http://localhost:7080/iframe Test iframe.
    + Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
    - JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
    * JavaScript Error: http://localhost:7080/javascript_error Test JS error.
    + Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
    - Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.

2. Open a Pull Request for Code Review.


## Submission Rubrics

### General Requirements
- [X] All tests should contain @Test annotation.
- [X] All tests should provide a setup and tear down mechanism that closes the browser.
- [X] All tests should run successfully from IDE. Provide a way to run tests on unix based OS.