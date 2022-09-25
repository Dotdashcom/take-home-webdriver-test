@Test
Feature: Drag and Drop Feature
  Verify user is able to drag and drop boxes

  Scenario: Drag and drop A box to B box
    Given user navigates to drag and drop page
    And user drags box A to box B
    Then box A is swapped with box B

  Scenario: Drag and drop B box to A box
    Given user navigates to drag and drop page
    And user drags box B to box A
    Then box A is swapped with box B