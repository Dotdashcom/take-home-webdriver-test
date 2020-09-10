#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Dynamic Loading

  Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.

  Scenario: Dynamic Loading

    Given user is on the Page "http://localhost:7080/dynamic_loading/2"
    When user clicks Start button
    Then user sees "Hello World!"