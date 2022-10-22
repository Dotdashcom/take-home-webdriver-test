@JavaScriptAlerts
Feature: Test confirm JS Alert.

  @Test
  Scenario: User Clicks on JS Alert Button and verifies alert messages
    Given user is on the "/javascript_alerts" JS Alert page
    When user clicks on JS Alert Button
    Then user verifies alert message
    And user clicks on JS confirm Button and clicks ok on alert
    Then user verifies the alert message'
    And user clicks on JS Prompt Button and types a "Take Home Assignment!" on Prompt.
    Then user asserts that the alert message contains the typed message.