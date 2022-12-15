Feature: Dropdown Functionality Test
 
    @Test
    Scenario: Dropdown funcionality
    Given I navigated to Dropdown website
    Then I selected dropdown Option1
    And I assert Option1 is selected
    Then I selected dropdown Option2
    And I assert Option2 is selected
    And I quit the browser