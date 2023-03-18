Feature: test dropdown

  @Test
    Scenario: Select options from dropdown menu

    Given user in "dropdown" page
    When user selects "Option 1" from dropdown
    Then verify "Option 1" has been selected
    When user selects "Option 2" from dropdown
    Then verify "Option 2" has been selected
