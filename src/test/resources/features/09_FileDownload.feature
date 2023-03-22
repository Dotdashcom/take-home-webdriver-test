@FileDownload
Feature: The scenarios for the File Download page

  Background: 
    Given navigate to the 'download' page

  @testFileDownload
  Scenario: Test File Download
  	And click on the file
    Then verify that the file is downloaded



