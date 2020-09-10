#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Dynamic Controls

  Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.

  Scenario: Dynamic Controls

    Given user is on the Page "http://localhost:7080/dynamic_controls"
    When user clicks Remove button
    Then user sees "It's gone!" and checkbox is removed
    When user clicks Add button and check the checkbox
    Then users sees checkbox checked
    When users clicks on Enable button and send text "Hello!" to the text box
    Then users sees "It's enabled!" and text into the text "Hello!" box