Feature: Dynamic Controls Operations

  @Test
  Scenario: As a User I want to be able to witness the miracle of sync solutions
    Given User is on Landing page
    And User clicks on "Dynamic Controls" submenu
    When User clicks on "Remove" Button
    Then User verifies that checkbox is gone
    And User clicks on "Add" Button
    Then User verifies that checkbox came back
    And User clicks on the Enable Button and uses explicit wait.
    Then User verifies that the text box is enabled.
    And clicks on the Disable Button and uses explicit wait.
    Then User verifies that the text box is disabled.