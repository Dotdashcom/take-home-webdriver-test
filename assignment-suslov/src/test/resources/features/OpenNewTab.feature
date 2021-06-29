@regression
Feature: Open in New Tab

  Scenario: Test clicks on the Click Here link.
  Test asserts that a new tab is opened with text New Window.
    Given user is on the Open in new Tap page
    When user clicks on the Click Here link
    Then asserts that a new tab is opened with text New Window

