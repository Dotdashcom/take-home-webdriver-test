@DynamicContent
Feature: Dynamic Content feature

  @Test
  Scenario: Content changes with page reload
    Given user is on the "/dynamic_content" Dynamic Content page
    When user refreshes the page
    Then user asserts that page content is changing and not same