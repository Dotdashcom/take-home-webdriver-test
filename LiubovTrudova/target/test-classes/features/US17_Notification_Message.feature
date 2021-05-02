Feature: Notification Message functionality


  Scenario:  verify Notification Message functionality works as expected
    Given navigate to Notification Message page
    Then click on click here link multiple times,verify message contain
      | Action successful                    |
      | Action unsuccesful, please try again |
      | Action unsuccesful                   |