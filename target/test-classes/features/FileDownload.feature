@test
Feature: File Download

  Scenario: Test clicks on the file.
  Test asserts that the file is downloaded.
    Given user is on the file download page
    When user click the some-file.txt
    Then it is downloaded