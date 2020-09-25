@TestAll
Feature: Login Function

  @Test1
  Scenario: Login Success
    Given User on login page
    When User enters "username" and "password"
    And User clicks on login button
    Then "You logged into a secure area!" should be visible





