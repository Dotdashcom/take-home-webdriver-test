#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Notification Message

  Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.

  Scenario: Notification Message

    Given user is on the Page "http://localhost:7080/notification_message_rendered"
    When user clicks the link to load the new message
    Then user sees notification message
      | Action unsuccesful, please try again |
      | Action successful                    |


