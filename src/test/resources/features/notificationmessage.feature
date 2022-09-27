@Test
Feature: Notification Message Feature
  Verify clicking link displays notification message

  Scenario: Click on "Click Here" link
    Given user navigates to notification message page
    When user clicks on "Click Here" link on notification message page
    Then notification message is displayed