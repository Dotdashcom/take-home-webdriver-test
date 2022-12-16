Feature: Context Menu Functionality Test
 
    @Test
    Scenario: Context Menu funcionality
    Given I navigated to Context Menu website
    When I rigt click the box 
    Then I assert the alert menu text
    And I quit the browser
