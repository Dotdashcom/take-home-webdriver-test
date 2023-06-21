@Checkbox
  Feature: Checkbox
    #JIRA_ID - JIRA_005

  Scenario: Check and Uncheck checkbox
    Given the user is on example home page
    When the user click on checkbox page
    Then the use should see the checkbox page
    When the user should check all the checkboxes on the checkbox page
    Then the user should see all the checkboxes are checked on the checkbox page
    When the user should uncheck all the checkboxes on the checkbox page
    Then the user should see all the checkboxes are unchecked on the checkbox page