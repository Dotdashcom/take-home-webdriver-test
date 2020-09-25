@TestAll
Feature: File Download

  @Test10
  Scenario: File Download
    Given User on File Download page
    When clicks on the file.
    Then the file is downloaded.