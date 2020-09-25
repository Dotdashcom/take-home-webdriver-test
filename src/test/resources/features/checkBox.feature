@TestAll
Feature: checkBox Test

  @Test3
  Scenario: Checkboxes
    Given User on Checkboxes Page
    When checkbox 1 is unchecked and checkbox 2 is checked
    And User checks checkbox 1 and unchecks checkbox 2
    Then checkbox 1 is checked and checkbox 2 is unchecked

