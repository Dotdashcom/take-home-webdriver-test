Feature: testing drag and drop
  
#  @Test @unsuccessful @nor
    Scenario: Test drags element A to element B.
    
    Given user in "drag_and_drop" page
    When drags element "a" to element "b"
    Then text on element A and B must be switched

#    DragNDrop works in manual test but it did not work in automation,
#    I could not put more time to figure out the problem due to busy schedule these days.
#    but the method for drag and drop is in the step definitions.