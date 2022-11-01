@test
Feature: Iframe
  Scenario: Test switches to Iframe and types some text.
  Test asserts that the typed text is as expected.
Given user is on the iframe page
    When user type in the iframe text box
    Then the typed text is as expected