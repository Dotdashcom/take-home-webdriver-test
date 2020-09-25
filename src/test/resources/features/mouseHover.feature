@TestAll
Feature: Mouse Hover

  @Test14
  Scenario: Mouse Hover
    Given User on Hovers page
    When User does a mouse hover on each image
    Then the additional information is displayed for each image