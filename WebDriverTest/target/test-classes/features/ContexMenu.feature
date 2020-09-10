#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Context Menu

  CContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'. Test JavaScript alert text on Right-Click.

  Scenario: Context click functionality

    Given user is on the Page "http://localhost:7080/context_menu"
    When user performs right click on the box
    Then Javascript alert is triggered and text "You selected a context menu" is displayed




