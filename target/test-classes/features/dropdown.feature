@Dropdown
Feature: Dropdown feature

  @Test
  Scenario: Select option 1 and 2 from dropdown
    Given user is on the "/dropdown" DropDown page
    When user selects option one and asserts that it is selected
    Then user selects option two and asserts that it is selected