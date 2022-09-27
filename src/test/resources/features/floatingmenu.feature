@Test
Feature: Floating Menu Feature
  Verify floating menu displayed after scrolling

  Scenario: Scrolling down the page
    Given user navigates to floating menu page
    When user scrolls down to the bottom of the page
    Then floating menu is still visible