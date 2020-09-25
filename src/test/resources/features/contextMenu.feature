@TestAll
Feature: Context Menu

  @Test4
  Scenario: Context Menu
    Given User on Context Menu page
    When User Right-click in the box
    Then asserts the alert message.