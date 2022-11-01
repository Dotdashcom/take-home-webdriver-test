@test
Feature: Dynamic Content

  Scenario: Test refreshes the page a couple of times.
  Test asserts that the content changes on each refresh.
    Given user is on the Dynamic content page
    When user clicks on the click here for  Dynamic content  changes
    Then content changes on each refresh
