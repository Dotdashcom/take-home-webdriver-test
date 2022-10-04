@DynamicLoading
Feature: Test Dynamic Loading using Explicit Waits.

  @Test
  Scenario: User clicks the start button and uses explicit wait and asserts that “Hello World!” text is displayed.
    Given user is on the "/dynamic_loading/2" Dynamic Loading page
    When user clicks on START button
    Then user verifies that "Hello World!" text is displayed