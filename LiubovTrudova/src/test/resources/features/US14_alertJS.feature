Feature: JavaScript Alerts functionality
Background:navigate to JavaScript Alerts page
  Given navigate to JavaScript Alerts page

  Scenario: verify JavaScript Alerts works as expected
    Given  Clicks on JS Alert Button and accept it
    Then asserts alert message is "You successfuly clicked an alert"

  Scenario: verify JavaScript Alerts works as expected
    Given  clicks on JS confirm Button and clicks ok on alert
    Then asserts alert message became "You clicked: Ok"


  Scenario: verify JavaScript Alerts works as expected
    Given  clicks on JS Prompt Button and type a "message" on Prompt
    Then asserts that the alert message contains the typed "message"