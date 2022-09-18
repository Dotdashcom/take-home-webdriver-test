
Feature: Test Floating Menu

  Scenario: Verify that the floating menu is still displayed when user scrolls the page

    Given user is on the "/floating_menu" page
    When user scrolls down the page
    Then verify that the floating menu is still displayed