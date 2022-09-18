
Feature: Test Login Success/Login Failure

  Scenario: Should be able to login with valid credentials
    Given user is on the "/login" page
    When user enters "valid" credentials
    Then user should see "You logged into a secure area!" msg

  Scenario: Should not be able to login with invalid credentials
    Given user is on the "/login" page
    When user enters "invalid" credentials
    Then user should see "Your username is invalid!" msg
