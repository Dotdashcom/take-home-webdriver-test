@ContextMenu
Feature: Checkbox
    #JIRA_ID - JIRA_006

  Scenario: Verify context menu
    <br> a. Verify right click
    <br> b. Verify JavaScript Alert

    Given the user is on example home page
    When the user clicks on context menu page
    Then the user should see the ContextMenu page
    When the user right-click in the dotted box in the ContextMenu page
    Then the user should see the context-menu in the ContextMenu page
