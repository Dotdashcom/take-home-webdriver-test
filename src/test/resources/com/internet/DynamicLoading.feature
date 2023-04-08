Feature: Dynamic Loading


    Background:
    Given User is on Landing page
    And User clicks on "Dynamic Loading" submenu



  Scenario: As a User I want to be able to see message after it loads when it's hidden
      When User clicks on "Example 1"
      And User clicks on Start button
      Then User verifies that text appears


    Scenario: As a User I want to be able to see message after it loads when it's doesn't exists
      When User clicks on "Example 2"
      And User clicks on Start button
      Then User verifies that text appears