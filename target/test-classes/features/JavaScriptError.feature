@test
Feature: JavaScript Error
  Scenario: Test finds the JavaScript error on the page.
  Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
    When user is on the JavaScript Error page
   Then asserts that the page contains error
