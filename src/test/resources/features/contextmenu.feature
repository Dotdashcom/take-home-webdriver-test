@Test
Feature: Context Menu Feature
  Verify user is able to interact with context box

  Scenario: Right click context box
    Given user navigates to context menu page
    When user right clicks on context box
    Then context menu alert box is displayed
    And context menu text is displayed