Feature: Open in New Tab

  @Test
  Scenario: As a User I want to be able to open new tabs
    Given User is on Landing page
    And User clicks on "Multiple Windows" submenu
    When User clicks on Click Here
    Then User verifies that new Tab opened with "New Window"