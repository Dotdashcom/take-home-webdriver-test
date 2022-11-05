Feature: CheckBoxes
  Test checks and unchecks checkboxes.
  Test uses assertions to make sure boxes were properly checked and unchecked.
  @CheckBoxes
  @Test
  Scenario:Click the checkboxes
    When User goes to go to checkboxes page
    Then User click the checkbox1
    Then  Checkbox1 is selected
    And  User click the checkbox2
    Then  Checkbox2 is selected
