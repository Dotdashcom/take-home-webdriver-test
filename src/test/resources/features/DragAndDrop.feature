@test
Feature: Drag and Drop

  Scenario: Test drags element A to element B.
  Test asserts that the text on element A and B are switched.
    Given user is on the drag and drop page
    When user drag A to drop B
    Then A and B is switched

