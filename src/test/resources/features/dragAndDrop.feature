@TestAll
Feature: Drag and Drop

  @Test5
  Scenario: Drag and Drop
    Given User on Drag and Drop page
    When User drags element A to element B
    Then text on element A and B are switched