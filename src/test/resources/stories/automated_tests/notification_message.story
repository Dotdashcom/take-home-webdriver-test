Meta:
@notificationMessage

Scenario: Notification Message
Meta:
@notificationMessage
Given the user is in home page
When the user navigate to 'notification_message_rendered'
When the user Click here to load notification message
Then notification message should be displayed