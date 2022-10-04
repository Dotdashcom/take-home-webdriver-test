@FileUpload
Feature: File upload Test

  @Test
  Scenario: Using upload functionality asserting the File Upload
    Given user is on "/upload" File Upload page
    When user selects and uploads the file with Upload Button
    Then user should be abel to assert successful completion