@UI
Feature: Hover Mouse

  Scenario Outline: Hover Mouse on the boxes

    Given I navigate to the Hover Mouse Page
    When I hover the mouse over the "<box>"
    Then Additional information should appear

    Examples:

    | box |
    | 1   |
    | 2   |
    | 3   |