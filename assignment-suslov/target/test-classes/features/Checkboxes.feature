@regression
Feature: checkBox feature
  Test checks and unchecks checkboxes.
  Test uses assertions to make sure boxes were properly checked and unchecked.

  Scenario:click the checkbox1
    Given user is on the checkbox page
    When user click the checkbox1
    Then  checkbox1 is selected

    Scenario: click the checkbox2
      When user click the checkbox2
      Then  checkbox2 is selected
