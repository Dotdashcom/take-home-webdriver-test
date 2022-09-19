
Feature: Test Notification Message

  Scenario: Verify that one of the “Action Successful”, “Action unsuccessful,
  please try again” and “Action Unsuccessful” messages show on click
  when user clicks on the Click Here link a multiple times

    Given user is on the "/notification_message_rendered" page
    When user clicks on the Click Here button
    Then verify that action message is displayed