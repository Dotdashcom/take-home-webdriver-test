@CheckBoxes
Feature: The scenarios for the CheckBoxes page

  Background: 
    Given navigate to the 'checkboxes' page

  @CheckBoxesChecked
  Scenario: select all checkboxes
  	And check all checkboxes
    Then verify all checkboxes are checked

  @CheckBoxesUnchecked
  Scenario: deselect all checkboxes
  	And unchecked all checkboxes
    Then verify all checkboxes are unchecked


