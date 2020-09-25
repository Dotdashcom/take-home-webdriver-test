@TestAll
Feature: JS Alert

  @Test15
  Scenario: JS Alert
    Given User on JS Alert page
    And asserts the alert message.
    When User Clicks on JS Alert Button.
    And clicks on JS confirm Button and clicks ok on alert.
    And asserts the alert message.
    And clicks on JS Prompt Button and types a message on Prompt.
    Then the alert message contains the typed message.