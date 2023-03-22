@DragAndDrop
Feature: The scenarios for the Drag and Drop page

  Background: 
    Given navigate to the 'drag_and_drop' page

  @testDragAndDrop
  Scenario: Test drags element A to element B
  	And drag element A to element B
    Then verify the text on elements A and B are switched



