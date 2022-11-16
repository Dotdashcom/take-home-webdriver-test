# The-Internet app testing. Java + Selenium

## Prerequisites
- Docker  [:link:](https://www.docker.com/products/docker-desktop/)
- Git  [:link:](https://github.com/git-guides/install-git)
- Java SE SDK v.19  [:link:](https://www.oracle.com/java/technologies/downloads/#java19)
- IDE such as IntelliJ  [:link:](https://www.jetbrains.com/idea/download/)
### Already included in this package
- ChromeDriver
- WebDriver
<br>

## Help
For help on using the run command, please refer to the _run_ command help
```
./run -h
```

## Installing
After installing and configuring the above pre-requisites, type the following:
```
git clone https://github.com/jpsugg/take-home-webdriver-test.git
chmod +x run
./run
```
_Note: the __run__ command pulls the docker images and configures the docker network automatically._
<br>

## Running
* Tests locally,

        ./run
* Tests against a remote Selenium Grid,

        ./run -r 

## Running faster
* Tests locally; spawns 4 threads in parallel,

        ./run -T 4
* Tests against a remote Selenium Grid; spawns 3 chrome-nodes in parallel with 3 max. concurrent sessions each,

        ./run -r -T 2
  
_Note: all the above commands, start and stop the Webapp and the Selenium Grid automatically._
_Note2: The amount of chrome nodes that will successfully run your tests will depend on your machine. On my machine, running more than 4 nodes may turn tests unstable._
<br>

## Stopping / Starting
* To manually start/stop the Webapp and Selenium Grid, without running the test suite:

        ./run -G start         # Initializes a Selenium Grid with 1 Chrome node
        ./run -G start -T 7    # Initializes a Selenium Grid with 7 Chrome nodes
        ./run -G stop          # Terminates the Grid

## Tests reporting
A test report can be found under:  
```
target/surefire-reports/index.html
```
<br>

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

### General Requirements
- [X] All tests contain @Test annotation.
- [X] All tests provide a setup and tear down mechanism that closes the browser.
- [X] All tests run successfully from IDE. A way to run tests on unix based OS is provided.
