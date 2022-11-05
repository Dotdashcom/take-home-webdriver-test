Feature: Dropdown
  @Dropdown
  @Test
  Scenario:
  Test selects Option 1 and Option 2 from the drop down menu.
  Test asserts Option 1 and Option 2 are selected.
    Given User goes to the DropDown page
    When User can select Option1 and see is selected
    Then User can select Option2  and see is selected