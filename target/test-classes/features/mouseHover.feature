@MouseHover
Feature: Mouse Hover Test

  @Test
  Scenario: User does a mouse hover on each image and asserts that additional information is displayed for each image.
    Given user is on "/hovers" Mouse Hover page
    When user hover overs each image
    Then user should be able to see additional information about each image