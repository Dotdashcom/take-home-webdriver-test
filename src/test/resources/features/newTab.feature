@TestAll
Feature: New Tab

  @Test17
  Scenario: New Tab
    Given User on New Tab
    When User clicks on the Click Here link
    Then assert that a new tab is opened with text "New Window"
