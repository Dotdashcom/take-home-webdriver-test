@OpenInNewTab
Feature: Test Link Opens in new tab.

  @Test
  Scenario: User clicks on the Click Here link and asserts that a new tab is opened with text New Window.
    Given user is on "/windows" New Window page
    When user clicks on Click Here link
    Then user should be able to verify that a new tab is opened with text New Window.