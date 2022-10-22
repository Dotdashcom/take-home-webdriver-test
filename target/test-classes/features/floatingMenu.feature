@FloatingMenu
Feature: Floating Menu Test

  @Test
  Scenario: Scroll the page and assert that the floating menu is still displayed
    Given user is on "/floating_menu" Floating Menu page
    When user scrolls down
    Then user should be able to assert that floating menu is still displayed