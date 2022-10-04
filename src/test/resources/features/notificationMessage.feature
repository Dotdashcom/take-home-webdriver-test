@NotificationMessage
Feature: Test notification Message.

  @Test
  Scenario: User clicks on the Click Here link a multiple times and verifies the messages
    Given user is on "/notification_message_rendered" Notification Message page
    When user clicks on Click Here link multiple times
    Then user should asserts that one of the notification messages shown on click.