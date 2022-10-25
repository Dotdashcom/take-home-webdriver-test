@JavaScriptError
Feature: Test JS error.

  @Test
  Scenario: User finds the JavaScript error on the page and user verifies that the page contains error:
  Cannot read property 'xyz' of undefined.
    Given user is on the "/javascript_error" JS Error page
    When user finds error on the page
    Then user asserts that the page contains error: "Cannot read properties of undefined (reading 'xyz')"
