Feature: Dropdown functionality
Background: navigate to Dropdown"
  Given navigate to "http://localhost:7080/dropdown"

  Scenario: Test selects Option 1 and Option 2 from the drop down menu.
    Given select option1
    Then verify option1 was selected
  Scenario: Test selects Option 1 and Option 2 from the drop down menu.
    Given select option2
    Then verify option2 was selected