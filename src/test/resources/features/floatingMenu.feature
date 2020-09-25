@TestAll
Feature: Floating Menu

  @Test12
  Scenario: Floating Menu
    Given User on Floating Menu page
    When scrolls the page
    Then floating menu is still displayed