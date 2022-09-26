@Test
Feature: Download Feature
  Verify download link is working, downloading file to device

  Scenario: Click on download link
    Given user navigates to download page
    When user clicks on download link
    And wait for three seconds
    Then file is downloaded to device