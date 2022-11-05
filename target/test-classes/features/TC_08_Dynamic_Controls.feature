Feature: Dynamic Controls

  Background:
    Given User goes to the Dynamic Controls page
    @DynamicC
    @Test
  Scenario: Click on the Remove/add button either of one is presented

    When User clicks on the Remove Button and uses explicit wait.
    Then User asserts that the checkbox is gone.
    And User clicks on Add Button and uses explicit wait.
    Then User asserts that the checkbox is present.

  Scenario:Click on the Enable button user will see the text either it's enabled or disabled
    When User clicks on the Enable Button and uses explicit wait.
    Then User asserts that the text box is enabled.
    And User clicks on the Disable Button and uses explicit wait.
    Then User asserts that the text box is disabled.