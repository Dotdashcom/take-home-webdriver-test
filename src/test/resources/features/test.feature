@test @regression
Feature: All Test Cases

  Background:
    Given User on the web page

  @checkbox
  Scenario: Checkboxes
    When Checkboxes page is launched
    And User checks the checkboxes
    Then Checkboxes are checked

  @contextmenu
  Scenario: Context Menu
    When Context Menu page is launched
    And User does right click on the square
    Then The Context Menu is displayed

  @dragdrop
  Scenario: Drag and Drop
    When Drag and Drop page is launched
    And User drags element A to element B
    Then User asserts that the text on element A and B are switched

  @dropdown
  Scenario: Dropdown
    When Dropdown page is launched
    Then User asserts "Option 1" and "Option 2" are selected

  @dyncont
  Scenario: Dynamic Content
    When Dynamic Content page is launched
    And User refreshes the page a couple of times
    Then User asserts that the content changes on each refresh

  @dyncontrols
  Scenario: Dynamic Content
    When Dynamic Controls page is launched
    And User clicks on the Remove Button and uses explicit wait
    Then User asserts that the checkbox is gone
    And User clicks on Add Button and uses explicit wait
    Then User asserts that the checkbox is present
    And User clicks on the Enable Button and uses explicit wait
    Then User asserts that the text box is enabled
    And  User clicks on the Disable Button and uses explicit wait
    Then User asserts that the text box is disabled


  @dynLoading
  Scenario: Dynamic Loading
    When Dynamic Loading page is launched
    And User clicks the start button and uses explicit wait
    Then User asserts that “Hello World!” text is displayed.


  @fileDownload
  Scenario:File Download
    When File Download page is launched
    And User clicks on the file
    Then User asserts that the file is downloaded


  @fileUpload
  Scenario:File Upload
    When File Upload page is launched
    And User uses Upload Button or Drag and Drop to upload a file
    Then User asserts that the file is uploaded


  @floatingMenu
  Scenario:Floating Menu
    When Floating Menu page is launched
    And User scrolls the page
    Then User asserts that the floating menu is still displayed


  @iFrame
  Scenario:Iframe
    When Iframe page is launched
    And User switches to Iframe and types some text
    Then User asserts that the typed text is as expected


  @mouseHover
  Scenario:Mouse Hover
    When Mouse Hover page is launched
    And User does a mouse hover on each image
    Then User asserts that additional information is displayed for each image


  @jsAlerts
  Scenario:JavaScript Alerts
    When JavaScript Alerts page is launched
    And User Clicks on JS Alert Button
    Then User asserts alert message
    And User clicks on JS confirm Button and clicks ok on alert
    Then User asserts the alert message
    When User clicks on JS Prompt Button and types a message on Prompt
    Then User asserts that the alert message contains the typed message


  @jsError
  Scenario:JavaScript Error
    When JavaScript Error page is launched
    And User finds the JavaScript error on the page
    Then User asserts that the page contains error: Cannot read property xyz of undefined


  @newTab
  Scenario:Open in New Tab
    When Open in New Tab page is launched
    And User clicks on the Click Here link
    Then User asserts that a new tab is opened with text New Window


  @notifyMsg
  Scenario:Notification Message
    When Notification Message page is launched
    And User clicks on the Click Here link a multiple times
    Then User asserts that one of the "Action successful", "Action unsuccessful, please try again", "Action Unsuccessful" messages show on click











