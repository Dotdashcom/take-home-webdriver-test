Feature: testing drag and drop
  
  @Test
    Scenario: Test drags element A to element B.
    
    Given user in "drag_and_drop" page
    When drags element "a" to element "b"
    Then text on element A and B must be switched