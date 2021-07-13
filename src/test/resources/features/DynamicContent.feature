@DynamicContent @All
Feature: DynamicContent

  Scenario: DynamicContent
	Given I navigate to url "http://localhost:7080/dynamic_content"
   	When  I verify content changes on each refresh
	
     
       