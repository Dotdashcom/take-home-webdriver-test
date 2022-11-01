@test
Feature: Mouse Hover
  Scenario: Test does a mouse hover on each image.
  Test asserts that additional information is displayed for each image.
    Given user is on the Mouse Hover page
    When mouse hover on each image
    Then additional information is displayed for each image.
