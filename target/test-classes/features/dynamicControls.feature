@DynamicControls
Feature: Test Dynamic Controls using Explicit Waits.

  @Test
  Scenario: Asserting functionality of each button and verifying their results
    Given user is on the "/dynamic_controls" Dynamic Controls page
    When user clicks on the Remove Button and uses explicit wait.
    Then asserts that the checkbox is gone.
    And user clicks on Add Button and uses explicit wait.
    Then user asserts that the checkbox is present.
    And user clicks on the Enable Button and uses explicit wait.
    Then user asserts that the text box is enabled.
    And user clicks on the Disable Button and uses explicit wait.
    Then user asserts that the text box is disabled.