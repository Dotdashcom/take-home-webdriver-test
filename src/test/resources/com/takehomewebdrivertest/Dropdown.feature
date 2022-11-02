@UI
Feature: Dropdown

  Scenario Outline: Select Options

    Given I navigate to the Dropdown Page
    When I select the "<option>"
    Then The "<option>" should appear as selected

    Examples:
    | option   |
    | Option 1 |
    | Option 2 |
