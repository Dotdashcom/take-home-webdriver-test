#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Open In Tab

  Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.

  Scenario: Open In Tab

    Given user is on the Page "http://localhost:7080/windows"
    When user clicks the link
    Then user sees "New Window" sign in newly opened window
