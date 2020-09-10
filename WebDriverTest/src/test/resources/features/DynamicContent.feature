#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Dynamic Content

  Scenario: Dynamic Content

    Given user is on the Page "http://localhost:7080/dynamic_content"
    When user refreshes the page
    Then user sees content is updated
