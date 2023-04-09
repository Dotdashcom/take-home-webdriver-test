Feature: Iframe Operations

  @Test
  Scenario: As a User I would like to be able to write text into a frame
    Given User is on Landing page
    And User clicks on "Iframe Menu" submenu
    When User writes into Iframe
    Then User verifies written text is intact