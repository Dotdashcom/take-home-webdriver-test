Feature: Dynamic Controls

  @Test
  Scenario:Verification and use of explicit wait

    Given I am on the Dynamic Controls page
    When I click on the Remove Button
    Then I verify the checkbox is gone
    When I click Add Button
    Then I assert that the checkbox is present
    When I click on the Enanble Button
    Then I assert that the text box is enabled
    When I click on the Disable Button
    Then I assert that the box is disabled


