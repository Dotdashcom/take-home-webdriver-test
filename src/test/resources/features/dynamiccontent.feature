@Test
Feature: Dynamic Content Feature
  Verify content changes on refresh

  Scenario: Refresh dynamic content page multiple times
    Given user navigates to dynamic content page
    Then content changes on multiple refresh