@UI
Feature: Drag and Drop

  Scenario: Move Box A to Box B location

    Given I navigate to the Drag and Drop Page
    When I move the Box A to the Box B location
    Then The Box A should be the second one

  Scenario: Move Box B to Box A location

    Given I navigate to the Drag and Drop Page
    When I move the Box B to the Box A location
    Then The Box B should be the first one

