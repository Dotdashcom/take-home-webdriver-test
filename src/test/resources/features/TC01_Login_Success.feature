Feature: User should be able to login with correct credentials

  Background:
    Given user is on the BaseUrl login page

  @Login_positive
  Scenario: positive login scenario
    When user enters username "tomsmith"
    And user enters password "SuperSecretPassword!"
    And user click login button
    Then user should see positive message "You logged into a secure area!"