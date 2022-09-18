
Feature: Test File Upload

  Scenario: Verify that the file is uploaded when uses Upload Button or Drag and Drop to upload a file

    Given user is on the "/upload" page
    When user upload a file into Choose File
    Then user clicks on Upload Button
    And verify that the file is uploaded