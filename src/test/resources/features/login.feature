@Login
Feature: Login feature

  @Test 
  Scenario: Login Success
    Given user is on the login page
    When user sends corrects login credentials
    Then user should land to dashboard

  @Test
  Scenario: Login Fail UserName
    Given user is on the login page
    When user sends incorrect username credentials
    Then user should see username error message

  @Test
  Scenario: Login Fail Password
    Given user is on the login page
    When user sends incorrect password credentials
    Then user should see password error message



