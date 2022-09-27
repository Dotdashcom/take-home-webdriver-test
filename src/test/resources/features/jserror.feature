@Test
Feature: JS Error Feature
  Verify JS error page contains errors

  Scenario: Navigate to JS error page
    Given user navigates to JS error page
    Then page contains errors