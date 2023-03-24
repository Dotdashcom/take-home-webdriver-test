Feature: File Upload

  @Test @nor
    Scenario: Test uses Upload Button or Drag and Drop to upload a file.
    
    Given user in "upload" page
    When user clicks "Choose File" button
    And user clicks "Upload" button
    Then user must see "File Uploaded!" message