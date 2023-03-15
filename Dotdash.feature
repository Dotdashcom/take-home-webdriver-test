
Feature: DotDash assignments

  @Test
  Scenario: Login Success
    Given User launches the loginpage
    When The user enters "tomsmith" and "SuperSecretPassword!"
    And User clicks the login button
    Then User verifys the login success text
    And user closes the browser
    
  @Test
  Scenario: Login Failure
    Given User launches the loginpage
    When The user enters "anita" and "invalidpword!"
    And User clicks the login button
    Then User verifys the login failure text 
    And user closes the browser   
    
  @Test
  Scenario: Checkboxes
    Given User launches the checkboxpage
    When User clicks checkbox1
    And User verifys checkbox1 is checked
    When User clicks checkbox1
    And User verifys checkbox1 is unchecked
    And user closes the browser
    
  @Test
  Scenario: Context Menu
    Given User launches the contextmenu page
    When User clicks on contextmenubox
    And User verify the text on the JS Alert
    And user closes the browser
  
  @Test
  Scenario: DropDown Menu
    Given User launches the dropdown page
    When User selects option1
    Then User verify option1 is selected
    And User selects option2
    Then User verify option2 is selected
    Then User verify option1 is not selected
    And user closes the browser
 

  @Test
  Scenario: iFrame
    Given User launches the iFrame page
    When User switch to iframe
    And User enters text in iframe
    Then User verify the text in the iframe
    And user closes the browser

  @Test
  Scenario: Mouse hover
    Given User launches the mousehover page
    When User switch to First image
    And User verify the first text
    When User switch to Second image
    And User verify the second text
    When User switch to Third image
    And User reads the third text
    And user closes the browser

  @Test
  Scenario: Java Script Alerts
    Given User launches the JS alerts page
    When User clicks on JS Alert
    Then User verify JS Alert message
    When User clicks on JS Confirm
    Then User verify JS Confirm message
    When User clicks on JS Prompt
    Then User verify JS Prompt message
    And user closes the browser
    
  @Test 
  Scenario: Drag and Drop
    Given User launches the drag and drop page
    When User drags ElementA to ElementB
    And user closes the browser

  @Test    
  Scenario: Java Script error
    Given User launches the JS error page
    When checkfor JS error and verify the text
    And user closes the browser
   
   @Test 
   Scenario: New Tab
    Given User launches the newTab page
    When user clicks on clickhere link
    And user moves to the new tab
    Then user asserts the text on the new window
    And user closes the browser
    
  @Test
  Scenario: Notification Message
    Given User launches the notification message page
    When user click on clickhere for Notification Message
    Then user validates whether the notification message is expected
    And user closes the browser

   @Test
   Scenario: Dynamic Content
    Given User launches the dynamic content page
    When user checks the page content
    And user refreshes the page
    Then user checks the page content after page refresh
    And user verify that page content has changed after refresh
    And user closes the browser
    
  @Test    
  Scenario: Floating Menu
    Given User launches the floating menu page
    And user checks whether the floating menu is visible
    And user scrolls to the bottom of the page
    And user checks whether the floating menu is visible
    And user closes the browser
    
  @Test    
  Scenario: File Uploader
    Given User launches the file uploader page
    And user upload the file
    And user verify the file is uploaded
    And user closes the browser

  @Test
  Scenario: File Download
    Given User launches the file download page
    And user download the file
    And user verify the file is downloaded
    And user closes the browser
    
  @Test    
  Scenario: Dynamic Loading
    Given User launches the dynamic loading page
    When user click start button
    And user wait for helloworld text to be displayed
    Then user verify the helloworld text  
    And user closes the browser

  @Test    
  Scenario: Dynamic Controls
    Given User launches the dynamic controls page
    When user clicks on the RemoveButton
    Then Verify that the checkbox is gone.
    When user clicks on AddButton
    Then Verify that the checkbox is present
    When user clicks on the EnableButton
    Then Verify that the text box is enabled
    When user clicks on the DisableButton
    Then Verify that the text box is disabled
    And user closes the browser



 