Feature: Drag and Drop Functionality Test
 
    @Test
    Scenario: Drag and Drop funcionality
    Given I navigated to Drag and Drop website
    When I Drag A to Drop on B 
    Then I assert the text on element A and B switched
    And I quit the browser
