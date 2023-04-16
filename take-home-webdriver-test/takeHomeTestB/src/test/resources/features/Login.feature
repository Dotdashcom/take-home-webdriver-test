Feature: User should  be able to login
  Background: Given User is on the Login Page
    @Login
    Scenario: Login as valid person
      When User enteris the valid information
      Then User should be able to login
