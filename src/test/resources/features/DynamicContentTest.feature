Feature: Dynamic Content Functionality Test
 
    @Test
    Scenario: Dynamic Content funcionality
    Given I navigated to Dynamic Content website
    Then I refresh the page a couple of times and assert for each refresh.
    And I quit the browser