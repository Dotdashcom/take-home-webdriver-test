@Dropdown
Feature: The scenarios for the Dropdown page

  Background: 
    Given navigate to the 'dropdown' page

  @testDropdown1
  Scenario: Test selects Option 1 from the drop-down menu  	
    Then select 'Option 1' from the drop-down menu and verify it was selected
    
    @testDropdown2
  Scenario: Test selects Option 2 from the drop-down menu  	
    Then select 'Option 2' from the drop-down menu and verify it was selected



