@OpenNewTab
Feature: OpenNewTab
    #JIRA_ID - JIRA_019

  Scenario: Verify Open New Tab
    Given the user is on example home page
    When the user clicks on the Open New Tab page
    Then the user should see the Open New Tab page
    When the user clicks on the "Click Here" link on the Open New Tab page
    Then the user should see the new tab is opened with text "New Window"




