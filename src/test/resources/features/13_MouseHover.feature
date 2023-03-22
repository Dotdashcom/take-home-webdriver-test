@MouseHover
Feature: The scenarios for the Mouse Hover page

  Background: 
    Given navigate to the 'hovers' page

  @testMouseHover
  Scenario Outline: Test mouse hover on '<number>' image
    And do a mouse hover on '<number>' image
    Then verify that additional information is displayed for '<number>' image

    Examples: 
      | number |
      |      1 |
      |      2 |
      |      3 |
