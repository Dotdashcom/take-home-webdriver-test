Feature: Login Scenarios

  Background:
    Given User navigates the website "http://localhost:7080/login"

  @run
  Scenario: Login Success
    When User enters username "tomsmith" and password "SuperSecretPassword!"
    Then User clicks the Login button
    Then User sees the welcome message "message"

  @run
  Scenario: Login Failure
      When User enters invalid username "Nottomsmith" and invalid password "SuperPassword!"
      Then User clicks the login button
      Then User sees the error message "message"
