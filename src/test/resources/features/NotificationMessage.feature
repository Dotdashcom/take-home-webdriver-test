Feature: Notification message

  @Test @nor

  Scenario: verify notification message is displayed

    Given user in "notification_message_rendered" page
    When user clicks on "Click here" link
    Then verify one of following messages is displayed
      | Action successful                    |
      | Action unsuccesful, please try again |
      | Action Unsuccessful                  |

#    I assume capital "S" of the message "Action Successful" in requirement is a typo, I corrected that
#    the letter "s" in Actual UI is lowercase

#  the word "unsuccesful" has typo as well, missing one "s"letter, I assume this is typo, no ticket required
#  after 20+ times trying I couldn't see "Action Unsuccessful" message, the letter "U" might need to be lowercase