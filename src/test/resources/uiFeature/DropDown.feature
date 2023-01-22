Feature: test DropDown

  @Test
  Scenario: user should be able to click on arrow to choose options in dropdown
    Given user should be able to Navigate to DropDown URL
    Then user click on the dropDown to choose second option
    Then driver should be clsoe