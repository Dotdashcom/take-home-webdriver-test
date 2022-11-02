@UI
Feature: Checkboxes

  Scenario: Check box 1

    Given I navigate to the Checkboxes Page
    When I click on the checkbox 1
    Then It should have the checked condition

  Scenario: Uncheck box 2

    Given I navigate to the Checkboxes Page
    When I click on the checkbox 2
    Then It should not have the checked condition