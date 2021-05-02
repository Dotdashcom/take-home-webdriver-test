
Feature: login functionality
@wip
  Scenario: Login as user with correct credentials
    Given I enter username
    When I enter password
    And click the sign in button
    Then Welcome to the Secure Area. When you are done click logout below souled be displayed


  Scenario: Login as user with incorrect credentials
    Given I enter username 'mambojambo'
    When I enter password 'mambojambo'
    And click the sign in button
    Then error message should contain "Your username is invalid"

