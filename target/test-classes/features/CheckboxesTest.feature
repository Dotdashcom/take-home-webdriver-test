Feature: Checkboxes Functionality Test
 
    @Test
    Scenario: Checkbox funcionality
    Given I navigated to CheckBox website
    When I check the checkboxes
    Then I validate that checkboxes are checked
    When I uncheck the checkBoxes
    Then I validate that checkboxes are unchecked
    And I quit the browser
