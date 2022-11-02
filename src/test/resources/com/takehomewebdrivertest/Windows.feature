@UI
Feature: Testing the new Tab

  Scenario Outline: Testing the new Tab

    Given I navigate to the Windows Page
    When I click on the link
    Then A new tab should appear
    And The "<message>" should appear

    Examples:
      | message           |
      | New Window        |