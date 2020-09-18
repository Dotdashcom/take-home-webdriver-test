Feature: Open In New Tab

@Test
Scenario: Verifying  that the new tab opens

  Given I am on the new tab page
  When I click Here link
  Then I assert that a new tab is opened with text New Window


