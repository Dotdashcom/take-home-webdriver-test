@all_tests
Feature: The internet tests

  Background: Make environment ready for testing
    Given I am on the main landing page

#1. Login Success
#* Page Object Model for the login page should be provided.
#+ Test is able to login successfully.
#- Test uses an assertion to make sure User has logged in.

#2. Login Failure
#* Page Object Model for the login page should be used.
#+ Test is not able to login with wrong credentials.
#- Test uses assertions to check Login failed for incorrect user and password.

  @1_2_login_test
  Scenario Outline: Login Success
    Given I go to login page
    And I put my username as "<username>" and password as "<password>"
    And I click login button
    Then verify that "<expectedMessage>" message is displayed

    Examples:
      | username | password             | expectedMessage                |
      | tomsmith | SuperSecretPassword! | You logged into a secure area! |
      | tomsmith | wrongPassword        | Your password is invalid!      |
      | fakeName | wrongPassword        | Your username is invalid!      |

#3. Checkboxes
#* Test checks and unchecks checkboxes.
#+ Test uses assertions to make sure boxes were properly checked and unchecked.
  @3_checkboxes
  Scenario: Checkboxes
    When I select "Checkboxes" option
    Then verify "checkbox 1" is "not selected"
    And verify "checkbox 2" is "selected"
    When I click checkboxes
    Then verify "checkbox 1" is "selected"
    And verify "checkbox 2" is "not selected"


#4. Context Menu
#* Test right clicks on the context menu.
#+ Test asserts the alert menu text.
  @4_context_menu
  Scenario: Context Menu
    When I select "Context Menu" option
    And I right-click on the context menu
    Then verify that alert has "You selected a context menu" message

#5. Drag and Drop
#* Test drags element A to element B.
#+ Test asserts that the text on element A and B are switched.
  @5_drag_and_drop
  Scenario: Drag and Drop
    When I select "Drag and Drop" option
    And I drag element A to element B
    Then verify that that the text on element A and B are switched.


#6. Dropdown
#* Test selects Option 1 and Option 2 from the drop down menu.
#+ Test asserts Option 1 and Option 2 are selected.
  @6_dropdown
  Scenario: Dropdown
    When I select "Dropdown" option
    And I select "Option 1" from dropdown menu
    Then assert that "Option 1" is selected
    And I select "Option 2" from dropdown menu
    Then assert that "Option 2" is selected


#7. Dynamic Content
#* Test refreshes the page a couple of times.
#+ Test asserts that the content changes on each refresh.
  @7_dynamic_content
  Scenario: Dynamic content
    When I select "Dynamic Content" option
    Then assert that content changes on each refresh


#8. Dynamic Controls
#* Test clicks on the Remove Button and uses explicit wait.
#+ Test asserts that the checkbox is gone.
#- Test clicks on Add Button and uses explicit wait.
#* Test asserts that the checkbox is present.
#+ Test clicks on the Enable Button and uses explicit wait.
#* Test asserts that the text box is enabled.
#+ Test clicks on the Disable Button and uses explicit wait.
#- Test asserts that the text box is disabled.
  @8_dynamic_controls
  Scenario: Dynamic controls
    When I select "Dynamic Controls" option
    * I click on "Remove" button
    Then assert that the checkbox is "not visible"
    * I click on "Add" button
    Then assert that the checkbox is "visible"
    * I click on "Enable" button
    Then assert that the text box is "enabled"
    * I click on "Disable" button
    Then assert that the text box is "disabled"






#9. Dynamic Loading
#* Test clicks the start button and uses explicit wait.
#+ Test asserts that “Hello World!” text is displayed.
  @9_dynamic_loading
  Scenario: Dynamic controls
    When I select "Dynamic Loading" option
    * I click on first example and click start button
    Then assert that "Hello World!" text is displayed.




#10. File Download
#* Test clicks on the file.
#+ Test asserts that the file is downloaded.
  @10_file_download
  Scenario: File Download
    When I select "File Download" option
    And I click on file "some-file.txt" filename
    Then "some-file.txt" is downloaded to specified path



#11. File Upload
#* Test uses Upload Button or Drag and Drop to upload a file.
#+ Test asserts that the file is uploaded.
  @11_file_upload
  Scenario: File Upload
    When I select "File Upload" option
    And I select "some-file.txt" from temp folder to upload
    Then verify that "some-file.txt" is displayed after uploading



#12. Floating Menu
#* Test scrolls the page.
#+ Test asserts that the floating menu is still displayed.
  @12_floating_menu
  Scenario: File Upload
    When I select "Floating Menu" option
    Then assert that the floating menu is displayed

    And I scroll down until by "900" px
    Then assert that the floating menu is displayed


#13. Iframe
#* Test switches to Iframe and types some text.
#+ Test asserts that the typed text is as expected.
  @13_iFrames
  Scenario: iFrames
    When I select "Frames" option
    And I click "iFrame" link text
    And I type "Hello Coder!" to the text input area
    Then asserts that the typed text is "Hello Coder!"


#14. Mouse Hover
#* Test does a mouse hover on each image.
#+ Test asserts that additional information is displayed for each image.
  @14_mouse_hover
  Scenario: Mouse Hover
    When I select "Hovers" option
    Then I mouse hover, assert that additional info is displayed

#15. JavaScript Alerts
#* Test Clicks on JS Alert Button.
#+ Test asserts alert message.
#- Test clicks on JS confirm Button and clicks ok on alert.
#* Test asserts the alert message.
#+ Test clicks on JS Prompt Button and types a message on Prompt.
#- Test asserts that the alert message contains the typed message.
  @15_js_alerts
  Scenario: JS Alert
    When I select "JavaScript Alerts" option
    And I click alert button "1"
    Then assert that alert message is "I am a JS Alert"
    And I click alert button "2"
    Then assert that alert message is "I am a JS Confirm"
    And I click alert button "3"
    * I enter "Hey there!" on alert input box
    Then assert that alert message is "Hey there!" is displayed on the page

#16. JavaScript Error
#* Test finds the JavaScript error on the page.
#+ Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
  @16_js_error
  Scenario: JS Error
    When I select "JavaScript onload event error" option
    Then asserts that the page contains error: "Cannot read property 'xyz' of undefined"


#17. Open in New Tab
#* Test clicks on the Click Here link.
#+ Test asserts that a new tab is opened with text New Window.
  @17_new_tab
  Scenario: Open New Tab
    When I select "Multiple Windows" option
    And I click "Click Here" link text
    Then assert that a new tab is opened with title "New Window"


#18. Notification Message
#* Test clicks on the Click Here link a multiple times.
#+ Test asserts that one of the “Action Successful”, “Action unsuccessful, please try again” and “Action Unsuccessful” messages show on click.
  @18_notifications
  Scenario: Notification message
    When I select "Notification Messages" option
    And I click "Click here" link text
    Then assert that one of the message is displayed:
      | Action successful                    |
      | Action unsuccesful, please try again |