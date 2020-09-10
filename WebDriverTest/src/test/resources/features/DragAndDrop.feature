#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Drag and Drop

  Drag and Drop: http://localhost:7080/drag_and_drop Perform Drag And Drop in a WebDriver test.

  Scenario: Drag and drop functionality

    Given user is on the Page "http://localhost:7080/drag_and_drop"
    When user drags one square and drops on another square
    Then user sees boxes "A" and "B" are swapped






