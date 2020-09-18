Feature: Drag and Drop

@Test
Scenario: Drag and Drop verification 

Given I am on the drag and drop page 
When I drag element A to element B
Then I verify the text on element A and B are switched 



