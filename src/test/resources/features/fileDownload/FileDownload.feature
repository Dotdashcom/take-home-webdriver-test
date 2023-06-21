@FileDownload
Feature: File Download
    #JIRA_ID - JIRA_012

  Scenario: Verify File Download
    Given the user is on example home page
    When the user clicks on file download page
    Then the user should see the file download page
    When the user clicks on the "some-file" link on the file download page
    Then the user should see the file is downloaded on the file download page


