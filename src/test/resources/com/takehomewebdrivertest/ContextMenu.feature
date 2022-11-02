@UI
Feature: Context Menu

  Scenario: Right click on the Box

    Given I navigate to the Context Menu Page
    When I right click on the box
    Then A Javascript alert should appear