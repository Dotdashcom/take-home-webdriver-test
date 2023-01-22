Feature: Check and Uncheck Box
  @test
  Scenario: User should be able to check and uncheck boxes
    Given User navigate to checkboxes URL
    Then user select checkbox numberOne
    Then user uncheck checkbox numberTwo
    Then close URL
