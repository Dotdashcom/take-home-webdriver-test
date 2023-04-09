Feature: Checkbox validation operation

    @Test
  Scenario: As a user I want to be able to click on checkbox
      Given User is on Landing page
      And User clicks on "Checkboxes" submenu
      When User clicks on first checkbox
      Then User observes that first checkbox is selected
      When User clicks on second checkbox
      Then User observes that second checkbox is unselected