@ContextMenu
Feature: Context Menu test

  @Test
  Scenario: Right click on context menu and handle Javascript alert
    Given user is on the "/context_menu" page
    When user right clicks on the context box
    Then user verifies alert text