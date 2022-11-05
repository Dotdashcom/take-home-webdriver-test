Feature: Context Menu
  @Content
  @Test
  Scenario:Test right clicks on the context menu.
  Test asserts the alert menu text.

    When User goes to the context menu
    And User does the right clicks in the box
    Then User sees Alert popped up and click
    And The right click page displayed


