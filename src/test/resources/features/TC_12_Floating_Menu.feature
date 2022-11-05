Feature: Floating Menu
  @Floating
  @Test
  Scenario: Test scrolls the page.
  Test asserts that the floating menu is still displayed.
    Given User goes to the Floating Menu page
    When User scrolls the page
    Then The floating menu is still displayed