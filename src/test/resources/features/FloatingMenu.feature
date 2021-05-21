@test
Feature: Floating Menu
  Scenario: Test scrolls the page.
  Test asserts that the floating menu is still displayed.
Given user is on the Floating Menu page
    When user scrolls the page
    Then the floating menu is still displayed