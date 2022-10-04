@FileDownload
Feature: Test File Download

  @Test
  Scenario: Test File Download.
    Given user is on the "/download" Download page
    When user clicks on the file
    Then user verifies that the file is downloaded