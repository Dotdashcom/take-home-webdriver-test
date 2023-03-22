@JavaScriptError
Feature: The scenarios for the JavaScript Error page

  Background: 
    Given navigate to the 'javascript_error' page

  @testJavaScriptError
  Scenario: Finds the JavaScript error on the page    
    Then verify that the page contains error: Cannot read property 'xyz' of undefined.

