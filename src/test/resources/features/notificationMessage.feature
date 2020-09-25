@TestAll
Feature: New Tab

  @Test18
  Scenario: New Tab
    Given User on Notification Message page
    When User clicks on the Click Here link a multiple times.
    Then assert that one of the "Action Successful", "Action unsuccessful, please try again" and "Action Unsuccessful" messages show on click.