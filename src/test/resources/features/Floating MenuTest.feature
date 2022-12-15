Feature:File Floating Menu Functionality Test
 
    @Test
    Scenario: Floating Menu funcionality
    Given I navigated to Floating Menu website
    Then I test scrolls the page until end.  
    And assert that the floating menu is still displayed
    And I quit the browser