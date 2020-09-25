@TestAll
Feature: Drop Down

  @Test6
  Scenario: Drop Down
    Given User on Drop Down page
    When User selects Option 1 and Option 2 from the drop down menu
    Then Option 1 and Option 2 are selected