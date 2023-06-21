@JavaScriptError
Feature: JavaScriptError
    #JIRA_ID - JIRA_017

  Scenario: Verify JavaScript Error
    Given the user is on example home page
    When the user clicks on the JavaScript Error page
    Then the user should see the JavaScript Error page
    Then the user verifies that there is a JavaScript Error on the JavaScript Error page
    Then the user should see the Javascript Error "Cannot read properties of undefined (reading 'xyz')" on the JavaScript Error page


