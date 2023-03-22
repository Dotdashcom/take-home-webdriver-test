@Login
Feature: The scenarios for the login page

  Background: 
    Given navigate to the 'login' page

  @loginSuccess
  Scenario: login with valid credentials
    Then verify login was successful

  @loginFailureUsername
  Scenario: login with an invalid username
    Then verify the error message for an invalid username

  @loginFailurePassword
  Scenario: login with an invalid password
    Then verify the error message for an invalid password
