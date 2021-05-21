@test
Feature: JavaScript Alerts
  Scenario: Test Clicks on JS Alert Button.
  Test asserts alert message.
  Test clicks on JS confirm Button and clicks ok on alert.
  Test asserts the alert message.
  Test clicks on JS Prompt Button and types a message on Prompt.
  Test asserts that the alert message contains the typed message.
Given user is on the alert page
    When user clicks on JS Alert Button alert message displayed
    And user clicks on JS confirm Button and clicks ok on alert
    Then new alert message is displayed
    When user clicks on JS Prompt Button and types a message on Prompt
    Then the alert message contains the typed message
