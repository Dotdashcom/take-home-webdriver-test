@ContextMenu
Feature: The scenarios for the ContextMenu page

  Background: 
    Given navigate to the 'context_menu' page

  @ContextMenuRightClick
  Scenario: Test right click on the context menu
  	And right click on the context menu
    Then verify the alert menu text



