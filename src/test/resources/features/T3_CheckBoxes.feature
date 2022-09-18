
Feature: Checkboxes

  Scenario: Verify boxes were properly checked and unchecked
    Given user is on the "/checkboxes" page
    Then verify checkbox one is NOT selected by default
    And verify checkbox two is SELECTED by default