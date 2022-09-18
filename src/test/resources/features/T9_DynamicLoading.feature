
Feature: Test Dynamic Loading

  Scenario: Verify that “Hello World!” text is displayed when user clicks on Start Button

    Given user is on the "/dynamic_loading/2" page
    When user clicks on Start Button
    Then verify that “Hello World!” text is displayed