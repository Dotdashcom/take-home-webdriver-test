@TestAll
Feature: Dynamic Loading

  @Test9
  Scenario: Dynamic Loading
    Given User on Dynamic Loading page
    When clicks the start button and uses explicit wait.
    Then asserts that "Hello World!" text is displayed.