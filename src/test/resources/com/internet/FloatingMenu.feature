Feature: Floating Operation

  @Test
  Scenario: As a User I want to be able to see floating menu even while scroll down
    Given User is on Landing page
    And User clicks on "Floating Menu" submenu
    When User scroll down to footer
    Then User verifies that floating menu is still visible

