Feature: Context Menu Right Click Operation
  
  
  Scenario: As a User I want to be able to receive alert after right clicking on context menu
    Given User is on Landing page
    And User clicks on "Context Menu" submenu
    And User right clicks on the box
    Then User observes that alert popup is displayed
