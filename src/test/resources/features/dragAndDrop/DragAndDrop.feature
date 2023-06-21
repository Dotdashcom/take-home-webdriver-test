@DragAndDrop
Feature: Drag And Drop
    #JIRA_ID - JIRA_007

  Scenario: Verify drag and drop
    Given the user is on example home page
    When the user clicks on drag and drop page
    Then the user should see the drag and drop page
    When the user drag draggable item 'A' into the item 'B' on the drag and drop page
    Then the user should see the item 'A' into the item 'B' on the drag and drop page
