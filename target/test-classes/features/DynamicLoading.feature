@test
Feature: Dynamic Loading

Scenario:
  Given user is on the dynamic loading page
When user clicks the start button and uses explicit wait.
Then  asserts that “Hello World!” text is displayed.
