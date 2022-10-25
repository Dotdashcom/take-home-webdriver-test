@DragDrop
Feature: Drag and Drop

  @Test
  Scenario: Drag element A and Drop to element B
    Given user is on "/drag_and_drop" page
    When user drags element A and drops to element B
    Then user should be abel to assert the text switch on the elements