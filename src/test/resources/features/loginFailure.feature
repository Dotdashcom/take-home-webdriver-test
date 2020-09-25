@TestAll
Feature: Login Function

  @Test2
  Scenario: Login Failure
    Given User on login page
    When User enters invalid "username" and "password"
    And User clicks on login button
    Then "Your username is invalid!" message should be visible