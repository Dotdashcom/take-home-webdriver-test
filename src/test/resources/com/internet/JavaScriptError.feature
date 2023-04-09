Feature: JS error Ops

  @Test
  Scenario: As a User I want to be able to see JS errors
    Given User is on Landing page
    And User clicks on "JavaScript onload event error" submenu
    Then User verifies that there is JS error on the page "Cannot read properties of undefined (reading 'xyz')"