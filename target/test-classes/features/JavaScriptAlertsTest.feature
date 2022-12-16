Feature: JavaScript Alerts Functionality Test
 
    @Test
    Scenario: JavaScript Alerts funcionality
    Given I navigated to JavaScript Alerts website
    Then I Clicks on JS Alert Button
    And I assert alert message
    Then I clicks on JS confirm Button and clicks ok on alert
    And I assert the alert message
    Then I clicks on JS Prompt Button and types a message on Prompt
    And I assert that the alert message contains the typed message
    And I quit the browser