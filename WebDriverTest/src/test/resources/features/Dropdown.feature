#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Dropdown

  Dropdown: http://localhost:7080/dropdown Test dropdown using WebDriver.

  Scenario: Dropdown verification

    Given user is on the Page "http://localhost:7080/dropdown"
    When user selects "Option 2"
    Then "Option 2" selected successfully


