
@Test
Feature: Validate Valid Login


  Scenario: Valid Login
    Given I enter valid name and invalid password and click login
    Then I validate user was not able to log in