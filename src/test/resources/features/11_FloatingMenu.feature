@FloatingMenu
Feature: The scenarios for the Floating Menu page

  Background: 
    Given navigate to the 'floating_menu' page

  @testFloatingMenu
  Scenario: Test the floating menu
  	And scroll the page
    Then verify the floating menu is still displayed



