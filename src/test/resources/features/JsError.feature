Feature: JS error on the page load

  @Test @unsuccessful @nor
    Scenario: finds the JavaScript error on the page.
    
    Given user in "javascript_error" page
    Then verify the "Cannot read properties of undefined (reading 'xyz')" error message

#    After trying multiple approaches, Unfortunately I couldn't get the err message from developer console of chrome.
#    This feature file does not works.