@UI
Feature: Dynamic Controls

  Scenario: Remove Element

    Given I navigate to the Dynamic Controls Page
    When I click on the remove button
    Then I wait until the element is removed

  Scenario: Add Element

    Given I navigate to the Dynamic Controls Page
    And I click on the remove button
    When I click on the add button
    Then I wait until the element is added

  Scenario: Enable Element

    Given I navigate to the Dynamic Controls Page
    When I click on the enable button
    Then I wait until the element is enabled

  Scenario: Disable Element

    Given I navigate to the Dynamic Controls Page
    And I click on the enable button
    When I click on the disable button
    Then I wait until the element is disable

