#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: iFrame

  iFrame: http://localhost:7080/iframe Test iFrame.

  Scenario: iFrame

    Given user is on the Page "http://localhost:7080/iframe"
    When User able to enter "Text" into the textBox
    Then User sees "Text" entered