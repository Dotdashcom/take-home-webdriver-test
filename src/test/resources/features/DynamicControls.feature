@test
Feature: Dynamic Controls

  Background:
    Given user is on the Dynamic Controls page

  Scenario: As user click on the Remove/add button either of one is presented

    When Test clicks on the Remove Button and uses explicit wait.
    Then   Test asserts that the checkbox is gone.
    And Test clicks on Add Button and uses explicit wait.
    Then Test asserts that the checkbox is present.

  Scenario: As user click on the Enable button user will see the text either it's enabled or disabled
    When Test clicks on the Enable Button and uses explicit wait.
    Then Test asserts that the text box is enabled.
    And Test clicks on the Disable Button and uses explicit wait.
    Then Test asserts that the text box is disabled.


