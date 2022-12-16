Feature: Dynamic Loading Functionality Test
 
    @Test
    Scenario: Dynamic Loading funcionality
    Given I navigated to Dynamic Loading website
    Then I click to start button with explicit wait
    And I asserts that Hello World text is displayed
    And I quit the browser
    
    