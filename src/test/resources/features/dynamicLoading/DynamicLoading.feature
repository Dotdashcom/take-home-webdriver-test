@DynamicLoading
Feature: Dynamic Loading
    #JIRA_ID - JIRA_011

  Scenario: Verify Dynamic Loading features - View Dynamic hidden page
    Given the user is on example home page
    When the user click on dynamic loading page
    Then the user should see the dynamic loading page
    When the user clicks on the "Example 1" link on the dynamic loading page
    Then the user should see the "Dynamically Loaded Page Elements" page on the dynamic loading page
    When the user clicks on the "Start" Button to view elements on the dynamic loading page
    Then the user should see the "Hello World!" text is displayed on the dynamic loading page

