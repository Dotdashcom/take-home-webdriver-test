@CheckBox
Feature: Check and UnCheck Boxes

  @Test
  Scenario: Assert that checkboxes checked and unchecked as per requirements
    Given user is on the /checkboxes page
    And user verifies checkbox one is not checked by default and checks it
    Then user verifies checkbox two is checked by default and unchecks it