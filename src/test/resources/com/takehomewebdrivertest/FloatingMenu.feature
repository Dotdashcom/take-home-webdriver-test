@UI
Feature: Floating Menu

  Scenario Outline: Testing the Floating Menu

    Given I navigate to the Floating Menu Page
    When I click on the "<floating menu>" button
    Then The URL should change "<floating menu>"

    Examples:

    | floating menu |
    | Home          |
    | News          |
    | Contacts      |
    | About         |