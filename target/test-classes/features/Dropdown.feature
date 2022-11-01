@test
Feature: Dropdown feature

  Scenario:
  Test selects Option 1 and Option 2 from the drop down menu.
  Test asserts Option 1 and Option 2 are selected.
    Given user is on the DropDown page
    When user select Option1 and Option2
    Then Option1 and Option2 is selected