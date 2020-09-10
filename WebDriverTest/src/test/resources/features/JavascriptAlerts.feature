#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Javascript Alerts

  JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.

  Scenario: Javascript Alerts

    Given user is on the Page "http://localhost:7080/javascript_alerts"
    When user clicks on buttons and interacts with "Alert" "Confirm" "Prompt" alerts, enters "Hello"
    Then user sees corresponding result messages
      | You successfuly clicked an alert |
      | You clicked: Ok                  |
      | You entered: Hello               |