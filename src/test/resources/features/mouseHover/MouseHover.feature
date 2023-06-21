@MouseHover
Feature: MouseHover
    #JIRA_ID - JIRA_016

  Scenario: Verify MouseHover
    Given the user is on example home page
    When the user clicks on the mouse hover page
    Then the user should see the mouse hover page
    When the user hover mouse on the mouse hover page
    Then the user should see the hover text "name" on the mouse hover page


