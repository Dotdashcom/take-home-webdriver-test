@DropDown
Feature: DropDown
    #JIRA_ID - JIRA_008

  Scenario: Verify DropDown features
    Given the user is on example home page
    When the user click on dropdown page
    Then the use should see the dropdown page
    When the user select "Option 1" dropdown on the dropdown page
    Then the user should see "Option 1" dropdown is selected on the dropdown page
    When the user select "Option 2" dropdown on the dropdown page
    Then the user should see "Option 2" dropdown is selected on the dropdown page