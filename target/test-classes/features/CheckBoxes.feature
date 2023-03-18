Feature: Test checks and unchecks checkboxes.

  @Test
  Scenario: check and uncheck the checkboxes

    Given user in "checkboxes" page
    Then verify user is able to check and uncheck checkboxes