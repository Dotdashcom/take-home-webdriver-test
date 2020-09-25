@TestAll
Feature: Dynamic Content

  @Test7
  Scenario: Dynamic Content
    Given User on Dynamic Content page
    When User refreshes the page
    Then Content changes each time