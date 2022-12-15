Feature: Open in New Tab Functionality Test
 
    @Test
    Scenario: Open in New Tab Alerts funcionality
    Given I navigated to Open in New Tab website
    Then I clicks on the Click Here link
    And I asserts that a new tab is opened with text New Window
    And I quit the browser