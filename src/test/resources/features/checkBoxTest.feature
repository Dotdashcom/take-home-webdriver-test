
@Test
Feature: Validate Check Box
  

  Scenario: Validate if checkbox is clickable
    Given I click on checkbox1 
    And I click on checkbox2
    Then I validate both checkboxes are clickable

