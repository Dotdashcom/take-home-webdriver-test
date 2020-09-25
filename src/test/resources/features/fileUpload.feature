@TestAll
Feature: File Upload

  @Test11
  Scenario: File Upload
    Given User on File Upload page
    When Upload Button or Drag and Drop to upload a file.
    Then the file is uploaded.