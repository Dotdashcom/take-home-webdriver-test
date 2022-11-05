Feature: JavaScript Alerts@Test15
@JavaScriptAlert
@Test
  Scenario: Test Clicks on JS Alert Button.
  Test asserts alert message.
  Test clicks on JS confirm Button and clicks ok on alert.
  Test asserts the alert message.
  Test clicks on JS Prompt Button and types a message on Prompt.
  Test asserts that the alert message contains the typed message.
    Given User goes to the alert page
    When User clicks on JS Alert Button alert message displayed
    And User clicks on JS confirm Button and clicks ok on alert
    Then Verify new alert message is displayed
    When User clicks on JS Prompt Button and types a message on Prompt
    Then the alert message contains the typed message