@NotificationMessage
Feature: The scenarios for the Notification Message page

  Background: 
    Given navigate to the 'notification_message_rendered' page

  @testNotificationMessage
  Scenario: Test Notification Message
    Then click on the Click Here link 7 times and verify that one of the messages shows on click
