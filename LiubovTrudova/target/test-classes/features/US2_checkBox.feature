Feature: checkboxes functionality

  Background: click checkboxes link
    Given click checkboxes link

  Scenario: verify checkboxes can be checked and unchecked
    Given check checkbox1
    Then verify checkbox1 was selected
    And uncheck checkbox1 verify checkbox1 unselected

  Scenario: verify checkboxes can be unchecked and checked
    Given uncheck checkbox2
    Then verify checkbox2 was unselected
    And check checkbox2 verify checkbox2 unselected
