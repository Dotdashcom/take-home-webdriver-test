@FileUpload @All
Feature: FileUpload

  Scenario: FileUpload
	Given I navigate to url "http://localhost:7080/upload"
   	When  I verify file uploaded
	
     
       