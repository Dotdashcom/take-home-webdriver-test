@Test
Feature: File Upload Feature
  Verify user can upload file on File Upload page

  Scenario: Uploading a file
    Given user navigates to file upload page
    When user selects a file
    And user clicks on upload button
    Then file is uploaded