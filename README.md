# WebDriver Tests by JP

## Prerequisites
* Docker
+ Git
- Java
* WebDriver
+ ChromeDriver
* IDE such as IntelliJ

## Installation
After installing and configuring the above pre-requisites, type the following:
```
git clone https://github.com/jpsugg/take-home-webdriver-test.git
chmod +x run
./run
```

## Running

* Tests locally,
   ```
   ./run
   ```
* Against a remote selenium grid,
   ```
   ./run -r 
   ```
## Running faster
* Tests locally; spawns 5 threads in parallel
   ```
   ./run -t 5
   ```
* Tests against a remote Selenium Grid; spawns 6 nodes in parallel
   ```
   ./run -r -t 6
   ```

## Stopping / Starting
* To start of stop the Selenium Grid:
```
./run -t 7 -g start    # Initializes a Selenium Grid with 7 Chrome nodes
./run -t stop          # Terminates the Grid
```

## Reporting
* A test report can be found under:
```
target/surefire-reports/index.html
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