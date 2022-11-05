Feature: File Upload
  @FileUpload
  @Test
  Scenario:Use Upload Button or Drag and Drop to upload a file.
  Asserts that the file is uploaded.

    Given User goes to the file upload page
    When User clicks choose file button and select
    And User clicks the upload button
    Then User can see File is Uploaded!