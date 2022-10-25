# WebDriver Tests by JP

## Prerequisites
* Docker
+ Git
- Java
* WebDriver
+ ChromeDriver
* IDE such as IntelliJ

## Installation
There's the easy way:
```
chmod +x setup
chmod +x run
./setup
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

3. (Optional) In case you don't have a Linux or Mac where to run these tests, you can configure the suite to run against a dockerized selenium grid running linux. 

   To do this, open the testng.xml file inside your project's root and do the following change:

   ```
   <!-- <parameter name="remote" value="http://0.0.0.0:4444/wd/hub"/> -->
   ```
   To this:
   ```
   <parameter name="remote" value="http://0.0.0.0:4444/wd/hub"/> 
   ```
4. (Optional) Also, take a look at the thread-count configuration in your testng.xml file, it may be useful (between 4 and 8 is fine):
   ```
   parallel = "tests" thread-count = "4">
   ```
5. (Optional) Then install the container like this:
   ```
   docker pull selenium/hub:latest
   docker pull selenium/node-chrome:4.5.2-20221021
   docker network create -o com.docker.network.bridge.bridge dotdash
   ```
## Running

There's the easy way:

* locally,
   ```
   ./run
   ```
* or using the selenium grid,
   ```
   ./run -d remote
   ```

And the other way

1. Run the following command for:
   Local execution:
   ```
   docker run -d -p 7080:5000 gprestes/the-internet
   ```
   Selenium grid execution:
   ```
   docker run -d --rm --net dotdash --name website -p 7080:5000 gprestes/the-internet
   docker run -d --rm --net dotdash --name selenium-hub -p 4442-4444:4442-4444 -v /dev/shm:/dev/shm selenium/hub:4.5.2-20221021
   docker run -d --net dotdash -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-chrome:4.5.2-20221021
   ```
2. Use the following BaseUrl for your tests:

   ```
   http://192.168.65.2:7080
   ```

   * (Optional) for you Selenium Grid:
   ```
   http://0.0.0.0:4444/wd/hub
   ```

3. To install the project, go to the project's root folder, and run:
   ```
   mvn clean install -f pom.xml -DskipTests
   ```   
4. To run the suite:
   locally,
   ```
   mvn test -DsuiteXmlFile=testng.xml
   ```
   or using the selenium grid,
   ```
   mvn test -DsuiteXmlFile=testng-selenium-grid.xml
   ```

## Stopping
To stop the docker containers, run:
   ```
   docker stop "$(docker ps -q --filter ancestor=gprestes/the-internet)"
   docker stop "$(docker ps -q --filter selenium/hub:4.5.2-20221021)"
   docker rm $(docker stop $(docker ps -a -q --filter selenium/node-chrome:4.5.2-20221021 --format="{{.ID}}"))
   ```

## Reporting
A test report can be found under:
```
<project folder>/target/surefire-reports/index.html
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