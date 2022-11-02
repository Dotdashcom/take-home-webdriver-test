# Webdriver Tests

## Webdriver Tests written by Nery Marin

I've used Selenium Webdriver along with Cucumber to run the tests.

All tests can be run within the IDE or by console using Maven and the following command:

`mvn -Dtest=RunCucumberTest test`

## Tests per feature file
- Login.feature:
  - Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
  - Login Failure: http://localhost:7080/login Login fail invalid creadentials
- Checkboxes.feature:
  - CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
- ContextMenu.feature:
  - ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'. Test JavaScript alert text on Right-Click.
- DragAndDrop.feature:
  - Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.
- Dropdown.feature:
  - Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
- DynamicControls.feature:
  - Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
- DynamicLoading.feature:
  - Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.
- Download.feature:
  - File Download: http://localhost:7080/download Test File Download.
- FloatingMenu.feature:
  - Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
- IFrame.feature:
  - Iframe: http://localhost:7080/iframe Test iframe.
- MouseHover.feature:
  - Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
- JavaScriptAlerts.feature:
  - JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
- Windows.feature:
  - Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
- NotificationMessage.feature:
  - Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.
 
 
 
I couldn't write an approach code to test the features Dynamic Content, File Upload and JavaScript Error.