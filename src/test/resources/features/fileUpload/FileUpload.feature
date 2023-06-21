@FileUpload
Feature: File Upload
    #JIRA_ID - JIRA_013

  Scenario: Verify File Upload
    Given the user is on example home page
    When the user clicks on file upload page
    Then the user should see the file upload page
    When the user clicks upload a test file on the file upload page
    Then the user should see the file is uploaded on the file upload page


