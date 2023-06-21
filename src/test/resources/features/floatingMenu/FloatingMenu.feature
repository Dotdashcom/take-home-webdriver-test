@FloatingMenu
Feature: Floating Menu
    #JIRA_ID - JIRA_014

  Scenario: Verify Floating Menu
    Given the user is on example home page
    When the user clicks on floating menu page
    Then the user should see the floating menu page
    When the user scrolls on the floating menu page
    Then the user should see the floating menu is still displayed on the floating menu page


