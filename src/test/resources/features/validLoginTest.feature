
@Test
Feature: Validate Valid Login


  Scenario: Valid Login
    Given I enter valid name and password and click login
    Then I validate user is logged in
    