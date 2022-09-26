@Test
Feature: Checkbox Feature
  Verify user is able to check and uncheck boxes

  Scenario: Check all boxes
    Given user navigates to checkboxes page
    When user checks on all boxes
    Then all boxes are selected

  Scenario: Uncheck all boxes
    Given user navigates to checkboxes page
    When user unchecks all boxes
    Then all boxes are not selected