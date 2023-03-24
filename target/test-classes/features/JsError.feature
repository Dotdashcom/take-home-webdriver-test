Feature: JS error on the page load

  @Test @unsuccessful @nor @wip
    Scenario: finds the JavaScript error on the page.
    
    Given user in "javascript_error" page
    Then verify the "Cannot read properties of undefined (reading 'xyz')" error message

