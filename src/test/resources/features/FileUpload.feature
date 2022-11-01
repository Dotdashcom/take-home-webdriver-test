@test
Feature: File Upload

  Scenario: Test uses Upload Button or Drag and Drop to upload a file.
  Test asserts that the file is uploaded.

    Given user is on the file upload page
    When user click chooseFIle button and select file
    And click the upload button
    Then user will see File is Uploaded!