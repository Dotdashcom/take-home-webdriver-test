#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Floating Menu

  Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.

  Scenario: Floating Menu

    Given user is on the Page "http://localhost:7080/floating_menu"
    When user scrolls down 1000 the page
    Then user sees the menu buttons are visible and accessible