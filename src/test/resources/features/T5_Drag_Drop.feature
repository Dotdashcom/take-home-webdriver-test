
Feature: Test Drag and Drop
  Scenario: Verify user drags element A to element B
    Given user is on the "/drag_and_drop" page
    When user drags element A and drop into element B
    Then verify the text on element A and B are switched.