@DynamicControls
Feature: DynamicControls
    #JIRA_ID - JIRA_010

  Scenario: Verify Dynamic Controls features
    Given the user is on example home page
    When the user click on dynamic control page
    Then the use should see the dynamic control page
    When the user clicks on the "Remove" Button to remove the checkbox on the dynamic control page
    Then the user should see the checkbox is removed on the dynamic control page
    When the user clicks on the "Add" Button to add the checkbox on the dynamic control page
    Then the user should see the checkbox is added on the dynamic control page
    When the user clicks on the "Enable" button to enable the text box on the dynamic control page
    Then the user should see the text box is enabled on the dynamic control page
    When the user clicks on the "Disable" button to disable the text box on the dynamic control page
    Then the user should see the text box is disabled on the dynamic control page

