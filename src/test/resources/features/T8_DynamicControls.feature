
Feature: Test Dynamic Controls

  Scenario: Verify that function of each features on each click.

    Given user is on the "/dynamic_controls" page
    When user clicks on Remove Button
    Then verify that the checkbox is gone
    When user clicks on Add Button
    Then verify that the checkbox is present
    When user clicks on the Enable Button
    Then verify that the text box is enabled
    When user clicks on the Disable Button
    Then verify that the text box is disabled