Feature: File Download
@FileDownload
@Test
  Scenario:Clicks on the file.
  Asserts that the file is downloaded.
    Given User goes to the file download page
    When User clicks the some-file.txt
    Then user can see it is downloaded