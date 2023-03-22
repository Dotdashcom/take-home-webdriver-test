@FileUpload
Feature: The scenarios for the File Upload page

  Background: 
    Given navigate to the 'upload' page

  @testFileUpload
  Scenario: Test File Uploader
  	And choose a file and click upload button to upload a file
    Then verify that the file is uploaded



