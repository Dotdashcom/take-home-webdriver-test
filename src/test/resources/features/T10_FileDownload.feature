
Feature: Test File Download

  Scenario: Verify that “Hello World!” text is displayed when user clicks on Start Button

    Given user is on the "/download" page
    When user clicks on file
    Then verify that the file is downloaded