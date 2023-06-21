@NotificationMessage
Feature: NotificationMessage
    #JIRA_ID - JIRA_020

  Scenario: Verify Notification Message
    Given the user is on example home page
    When the user clicks on the Notification Message page
    Then the user should see the Notification Message page
    Then the user clicks on the "Click here" link to see "Action successful" notification on the Notification Message page
    Then the user clicks on the "Click here" link to see "Action unsuccesful, please try again" notification on the Notification Message page



