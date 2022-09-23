
@Test
Feature: Validate Drag and Drop

  
  Scenario: Validate drag and drop from a to b
    Given I drag box A and drop in box B
    Then I validate that box A is in box B
 
