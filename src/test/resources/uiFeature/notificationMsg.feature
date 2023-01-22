Feature: notification message
  @Test
  Scenario: user click on notification message and get notify
    Given user Navigate to notification URL
    When user click on notification for one time it will receive message "Action unsuccesful" or "Action successful"
