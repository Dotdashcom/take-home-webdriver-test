Feature: Dynamic Controls Functionality Test
 
    @Test
    Scenario: Dynamic Controls funcionality
    Given I navigated to Dynamic Controls website
    Then I click to remove button with explicit wait
    And I asserts that the checkbox is gone
    Then I click to add button with explicit wait
    And I asserts that the checkbox is present
    Then I click to Enable button with explicit wait
    And I asserts that the text box is enabled
    Then I click to Disable button with explicit wait
    And I asserts that the text box is disabled
    And I quit the browser
    
    