
Feature: Test Open in New Tab

  Scenario: Verify that a new tab is opened with text New Window when user clicks on the Click Here link

    Given user is on the "/windows" page
    When user clicks on the Click Here link
    Then verify that a new tab is opened with text New Window