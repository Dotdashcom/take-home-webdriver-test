@Test
Feature: New Window Feature
  Verify clicking link opens in a new tab

  Scenario: Click on "Click Here" link
    Given user navigates to new window page
    When user clicks on "Click Here" link on new window page
    Then new tab is opened with text "New Window"