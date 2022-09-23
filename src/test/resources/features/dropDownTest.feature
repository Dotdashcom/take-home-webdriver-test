
@Test
Feature: Validate drop down list

 
  Scenario: Validate if I can click on drop down list and get its elements
    Given I verify drop down
    Then I validate drop down options are selectable
 
