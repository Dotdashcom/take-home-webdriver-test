@test1
Feature: checkBox feature
  Test checks and unchecks checkboxes.
  Test uses assertions to make sure boxes were properly checked and unchecked.

  Background: User is already in checkbox page
    Given user is on the checkbox page
  Scenario:click the checkbox1
    When user click the checkbox1
    Then  checkbox1 is selected

    Scenario: click the checkbox2
      When user click the checkbox2
      Then  checkbox2 is selected
