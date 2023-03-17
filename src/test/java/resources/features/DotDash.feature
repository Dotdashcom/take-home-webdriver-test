Feature: DotDash assignments

  @Test_case1
  Scenario: Login Success
    Given User launches the loginpage
    When User enters "tomsmith" and "SuperSecretPassword!"
    And User clicks the login button
    Then User verifies the login success text
    And user closes the browser

  @Test_case2
  Scenario: Login Failure
    Given User launches the loginpage
    When User enters "John" and "incorrectPassword"
    And User clicks the login button
    Then User verifies the login failure text
    And user closes the browser

  @Test_case3
  Scenario: Checkboxes
    Given User launches the checkBoxPage
    When User clicks the checkBox1
    And User verifies if checkBox1 is checked
    When User clicks the checkBox1
    And User verifies if checkBox1 is unchecked
    And user closes the browser

  @Test_case4
  Scenario: Context Menu
    Given User launches the contextMenu page
    When User clicks on contextMenuBox
    And User verify the text on the JS Alert
    And user closes the browser

  @Test_case5
  Scenario: DropDown Menu
    Given User launches the dropdown page
    When User selects option1
    Then User verifies option1 is selected
    And User selects option2
    Then User verifies option2 is selected
    Then User verifies option1 is not selected
    And user closes the browser

  @Test_case6
  Scenario: iFrame
    Given User launches the iFrame page
    When User switches to iframe
    And User enters text in iframe
    Then User verifies the text in the iframe
    And user closes the browser

  @Test_case7
  Scenario: Mouse hover
    Given User launches the mousehover page
    When User switches to first image
    And User verifies the first text
    When User switches to second image
    And User verifies the second text
    When User switches to third image
    And User reads the third text
    And user closes the browser

  @Test_case8
  Scenario: Java Script Alerts
    Given User launches the JS alerts page
    When User clicks on JS Alert
    Then User verifies JS Alert message
    When User clicks on JS Confirm
    Then User verifies JS Confirm message
    When User clicks on JS Prompt
    Then User verifies JS Prompt message
    And user closes the browser

  @Test_case9
  Scenario: Drag and Drop
    Given User launches the drag and drop page
    When User drags ElementA to ElementB
    And user closes the browser

  @Test_case10
  Scenario: Java Script error
    Given User launches the JS error page
    When Check for JS error and verify the text
    And user closes the browser

  @Test_case11
  Scenario: New Tab
    Given User launches the newTab page
    When User clicks on clickhere link
    And User moves to the new tab
    Then User asserts the text on the new window
    And user closes the browser

  @Test_case12
  Scenario: Notification Message
    Given User launches the notification message page
    When User clicks on clickhere for Notification Message
    Then User validates whether the notification message is expected
    And user closes the browser

  @Test_case13
  Scenario: Dynamic Content
    Given User launches the dynamic content page
    When user checks the page content
    And user refreshes the page
    Then user checks the page content after page refresh
    And user verifies that page content has changed after refresh
    And user closes the browser

  @Test_case14
  Scenario: Floating Menu
    Given User launches the floating menu page
    And User checks whether the floating menu is visible
    And User scrolls to the bottom of the page
    And User checks whether the floating menu is visible
    And user closes the browser

  @Test_case15
  Scenario: File Uploader
    Given User launches the file uploader page
    And User uploads the file
    And User verifies the file is uploaded
    And user closes the browser

  @Test_case16
  Scenario: File Download
    Given User launches the file download page
    And User download the file
    And User verifies the file is downloaded
    And user closes the browser

  @Test_case17
  Scenario: Dynamic Loading
    Given User launches the dynamic loading page
    When User clicks on start button
    And User waits for helloworld text to be displayed
    Then User verifies the helloworld text
    And user closes the browser

  @Test_case18
  Scenario: Dynamic Controls
    Given User launches the dynamic controls page
    When User clicks on the RemoveButton
    Then Verify that the checkbox is gone.
    When User clicks on AddButton
    Then Verify that the checkbox is present
    When User clicks on the EnableButton
    Then Verify that the text box is enabled
    When User clicks on the DisableButton
    Then Verify that the text box is disabled
    And user closes the browser
