@UI
Feature: Dynamic Loading

  Scenario: Validate text presence after click on the Start Button

    Given I navigate to the Dynamic Loading Page
    When I click on the Start Button
    Then I wait until the text appears