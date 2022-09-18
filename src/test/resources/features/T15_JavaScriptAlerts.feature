
Feature: Test JavaScript Alerts

  Scenario: Verify that the alert message when user clicks on each JS Button

    Given user is on the "/javascript_alerts" page
    When user clicks on JS Alert Button
    Then verify alert message
    When user clicks JS confirm Button
    And clicks ok on alert
    Then verify the alert message
    When user clicks on JS Prompt Button
    And types a message on Prompt
    Then verify alert message contains the typed message
