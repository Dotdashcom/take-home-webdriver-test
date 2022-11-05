Feature: JavaScript Error
  @JavascriptError
  @Test
  Scenario: Test finds the JavaScript error on the page.
  Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
    When User goes to the JavaScript Error page
    Then  User can see asserts that the page contains error