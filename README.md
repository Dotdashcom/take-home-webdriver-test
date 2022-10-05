# Webdriver Tests
## Prerequisites
  * Docker
  + Git
  - Java
  * Webdriver
  + ChromeDriver
  * IDE such as IntelliJ

## Steps
1. Pull Docker image for the-internet app:
  
    `docker pull gprestes/the-internet`
  
2. Run the following command: 

    `docker run -d -p 7080:5000 gprestes/the-internet`
  
3. Set the following BaseUrl for your tests:

   `http://localhost:7080`
   
4. Use ChromeDriver to write Tests for the following scenarios in Java:
    * Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
    + Login Failure: http://localhost:7080/login Login fail invalid creadentials
    - CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
    * ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'. test JavaScript alert text on Right-Click.
    + Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.
    - Dropdown: http://localhost:7080/dropdown test dropdown using Webdriver.
    * Dynamic Content: http://localhost:7080/dynamic_content test content changes with page reload.
    + Dynamic Controls: http://localhost:7080/dynamic_controls test Dynamic Controls using Explicit Waits.
    - Dynamic Loading: http://localhost:7080/dynamic_loading/2 test Dynamic Loading using Explict Waits.
    * File Download: http://localhost:7080/download test File Download.
    + File Upload: http://localhost:7080/upload test File Upload.
    - Floating Menu: http://localhost:7080/floating_menu test Floating Menu.
    * Iframe: http://localhost:7080/iframe test iframe.
    + Mouse Hover: http://localhost:7080/hovers test Mouse Hover.
    - JavaScript Alerts: http://localhost:7080/javascript_alerts test confirm JS Alert.
    * JavaScript Error: http://localhost:7080/javascript_error test JS error.
    + Open in New Tab: http://localhost:7080/windows test Link Opens in new tab.
    - Notification Message: http://localhost:7080/notification_message_rendered test notification Message.
  
5. Open a Pull Request for Code Review.  
  
  
## Submission Rubrics

### General Requirements
1. All tests should contain @test annotation.
2. All tests should provide a setup and tear down mechanism that closes the browser.
3. All tests should run successfully from IDE. Provide a way to run tests on unix based OS.


### test Specific Rubrics

1. Login Success
   * pages Object Model for the login page should be provided.
   + test is able to login successfully.
   - test uses an assertion to make sure User has logged in.

2. Login Failure
   * pages Object Model for the login page should be used.
   + test is not able to login with wrong credentials.
   - test uses assertions to check Login failed for incorrect user and password.

3. Checkboxes
   * test checks and unchecks checkboxes.
   + test uses assertions to make sure boxes were properly checked and unchecked.
4. Context Menu
   * test right clicks on the context menu.
   + test asserts the alert menu text.
5. Drag and Drop
   * test drags element A to element B.
   + test asserts that the text on element A and B are switched.
6. Dropdown
   * test selects Option 1 and Option 2 from the drop down menu.
   + test asserts Option 1 and Option 2 are selected.
7. Dynamic Content
   * test refreshes the page a couple of times.
   + test asserts that the content changes on each refresh.
8. Dynamic Controls
   * test clicks on the Remove Button and uses explicit wait.
   + test asserts that the checkbox is gone.
   - test clicks on Add Button and uses explicit wait.
   * test asserts that the checkbox is present.
   + test clicks on the Enable Button and uses explicit wait.
   * test asserts that the text box is enabled.
   + test clicks on the Disable Button and uses explicit wait.
   - test asserts that the text box is disabled.
9. Dynamic Loading
   * test clicks the start button and uses explicit wait.
   + test asserts that “Hello World!” text is displayed.
10. File Download
    * test clicks on the file.
    + test asserts that the file is downloaded.
11. File Upload
    * test uses Upload Button or Drag and Drop to upload a file.
    + test asserts that the file is uploaded.
12. Floating Menu
    * test scrolls the page.
    + test asserts that the floating menu is still displayed.
13. Iframe
    * test switches to Iframe and types some text.
    + test asserts that the typed text is as expected.
14. Mouse Hover
    * test does a mouse hover on each image.
    + test asserts that additional information is displayed for each image.
15. JavaScript Alerts
    * test Clicks on JS Alert Button.
    + test asserts alert message.
    - test clicks on JS confirm Button and clicks ok on alert.
    * test asserts the alert message.
    + test clicks on JS Prompt Button and types a message on Prompt.
    - test asserts that the alert message contains the typed message.
16. JavaScript Error
    * test finds the JavaScript error on the page.
    + test asserts that the page contains error: Cannot read property 'xyz' of undefined.
17. Open in New Tab
    * test clicks on the Click Here link.
    + test asserts that a new tab is opened with text New Window.
18. Notification Message
    * test clicks on the Click Here link a multiple times.
    + test asserts that one of the “Action Successful”, “Action unsuccessful, please try again” and “Action Unsuccessful” messages show on click.

 
