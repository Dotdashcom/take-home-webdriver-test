Feature: Drag and Drop Operations


  Scenario: As a User I want to be able to drag and Drop from point A to B
    Given User is on Landing page
    And User clicks on "Drag and Drop" submenu
    And User drags point A and then Drop to Point B Location
    Then User observes that position of Point A is switched with Point B
