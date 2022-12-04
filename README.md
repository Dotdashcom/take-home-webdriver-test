Webdriver Tests
Prerequisites
Docker
Git
Java
Webdriver
ChromeDriver
IDE such as IntelliJ
Steps
Pull Docker image for the-internet app:

docker pull gprestes/the-internet

Run the following command:

docker run -d -p 7080:5000 gprestes/the-internet

Set the following BaseUrl for your tests:

http://localhost:7080

Use ChromeDriver to write Tests for the following scenarios in Java:

Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
Login Failure: http://localhost:7080/login Login fail invalid creadentials
CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'. Test JavaScript alert text on Right-Click.
Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.
Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.
Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.
File Download: http://localhost:7080/download Test File Download.
File Upload: http://localhost:7080/upload Test File Upload.
Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
Iframe: http://localhost:7080/iframe Test iframe.
Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
JavaScript Error: http://localhost:7080/javascript_error Test JS error.
Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.
Open a Pull Request for Code Review.

Submission Rubrics
General Requirements
All tests should contain @Test annotation.
All tests should provide a setup and tear down mechanism that closes the browser.
All tests should run successfully from IDE. Provide a way to run tests on unix based OS.
Test Specific Rubrics
Login Success

Page Object Model for the login page should be provided.
Test is able to login successfully.
Test uses an assertion to make sure User has logged in.
Login Failure

Page Object Model for the login page should be used.
Test is not able to login with wrong credentials.
Test uses assertions to check Login failed for incorrect user and password.
Checkboxes

Test checks and unchecks checkboxes.
Test uses assertions to make sure boxes were properly checked and unchecked.
Context Menu

Test right clicks on the context menu.
Test asserts the alert menu text.
Drag and Drop

Test drags element A to element B.
Test asserts that the text on element A and B are switched.
Dropdown

Test selects Option 1 and Option 2 from the drop down menu.
Test asserts Option 1 and Option 2 are selected.
Dynamic Content

Test refreshes the page a couple of times.
Test asserts that the content changes on each refresh.
Dynamic Controls

Test clicks on the Remove Button and uses explicit wait.
Test asserts that the checkbox is gone.
Test clicks on Add Button and uses explicit wait.
Test asserts that the checkbox is present.
Test clicks on the Enable Button and uses explicit wait.
Test asserts that the text box is enabled.
Test clicks on the Disable Button and uses explicit wait.
Test asserts that the text box is disabled.
Dynamic Loading

Test clicks the start button and uses explicit wait.
Test asserts that “Hello World!” text is displayed.
File Download

Test clicks on the file.
Test asserts that the file is downloaded.
File Upload

Test uses Upload Button or Drag and Drop to upload a file.
Test asserts that the file is uploaded.
Floating Menu

Test scrolls the page.
Test asserts that the floating menu is still displayed.
Iframe

Test switches to Iframe and types some text.
Test asserts that the typed text is as expected.
Mouse Hover

Test does a mouse hover on each image.
Test asserts that additional information is displayed for each image.
JavaScript Alerts

Test Clicks on JS Alert Button.
Test asserts alert message.
Test clicks on JS confirm Button and clicks ok on alert.
Test asserts the alert message.
Test clicks on JS Prompt Button and types a message on Prompt.
Test asserts that the alert message contains the typed message.
JavaScript Error

Test finds the JavaScript error on the page.
Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
Open in New Tab

Test clicks on the Click Here link.
Test asserts that a new tab is opened with text New Window.
Notification Message

Test clicks on the Click Here link a multiple times.
Test asserts that one of the “Action Successful”, “Action unsuccessful, please try again” and “Action Unsuccessful” messages show on click.