@Test
Feature: Dynamic Loading Feature
  Verify element is dynamically loaded on page

  Scenario: Click on start button
    Given user navigates to the dynamic loading page
    And user clicks on the start button
    Then hello world text is displayed