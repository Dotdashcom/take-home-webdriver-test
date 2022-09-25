@Test
Feature: Login Feature
  Verify user is able to log in to the site

  Scenario: Login with valid credentials
    Given user navigates to Login page
    And user inputs "valid" username
    And user inputs "valid" password
    And user clicks login button
    Then user is logged in successfully

  Scenario: Login with invalid credentials
    Given user navigates to Login page
    And user inputs "valid" username
    And user inputs "invalid" password
    And user clicks login button
    Then user is unable to login


