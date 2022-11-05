Feature: Drag and Drop
  @DragDrop
  @Test
  Scenario: Test drags element A to element B.
  Test asserts that the text on element A and B are switched.
    Given User goes to the drag and drop page
    When user drags A to drop B
    Then user sees A and B is switched