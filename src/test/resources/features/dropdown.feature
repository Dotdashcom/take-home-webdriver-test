@Test
Feature: Drop Down Feature
  Verify user is able select drop down options
  
  Scenario Outline: Select option 1 from drop down list
    Given user navigates to drop down page
    When user selects dropdown "<option>"
    Then dropdown option "<option>" is selected

    Examples:
      |  option    |
      |  Option 1  |
      |  Option 2  |