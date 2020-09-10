#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Javascript Error

  JavaScript Error: http://localhost:7080/javascript_error Test JS error.

  Scenario: Javascript Error Test

    Given user is on the Page "http://localhost:7080/javascript_error"
    Then user sees the error and verifies "JavaScript error"