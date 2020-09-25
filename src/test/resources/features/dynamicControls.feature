@TestAll
Feature: Dynamic Controls

  @Test8
  Scenario: Dynamic Controls
    Given User on Dynamic Controls page
    When User clicks on the Remove Button and uses explicit wait
    Then asserts that the checkbox is gone.
    And clicks on Add Button and uses explicit wait.
    Then asserts that the checkbox is present.
    And clicks on the Enable Button and uses explicit wait.
    Then asserts that the text box is enabled.
    And clicks on the Disable Button and uses explicit wait.
    Then asserts that the text box is disabled.