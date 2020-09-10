#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Checkboxes

  CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes

  Scenario: Check and uncheck boxes

    Given user is on the Page "http://localhost:7080/checkboxes"
    When user clicks on checkboxes
    Then user sees "checkbox 1" and "checkbox 2" work correctly




