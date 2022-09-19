
Feature: Test JavaScript Error

  Scenario: Verify that the page contains error: Cannot read property 'xyz' of undefined

    Given user is on the "/javascript_error" page
    Then verify that the page contains error: "Cannot read properties of undefined (reading 'xyz')"