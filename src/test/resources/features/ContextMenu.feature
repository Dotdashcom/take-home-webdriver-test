Feature: Testing Context Menu

  @Test
  Scenario: Right-click in the box to see one called 'the-internet'. Test
    
    Given user in "context_menu" page
    When user performs Right-click on the box
    Then user mut see alert displayed on the page