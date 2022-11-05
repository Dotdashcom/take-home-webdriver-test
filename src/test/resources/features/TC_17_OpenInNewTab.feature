Feature: Open in New Tab
  @OpenTab
  @Test
  Scenario: Test clicks on the Click Here link.
  Test asserts that a new tab is opened with text New Window.
    Given User goes in the Open in new Tap page
    When User clicks on the Click Here link
    Then User asserts that a new tab is opened with text New Window