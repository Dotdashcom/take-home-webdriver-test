@ContextMenu @All
Feature: ContextMenu

  Scenario: ContextMenu
	Given I navigate to url "http://localhost:7080/context_menu"
   	Then  I right click and verify the alert
	
     
       