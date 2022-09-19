
Feature: Test Mouse Hover

  Scenario: Verify that additional information is displayed for each image when user does a mouse hover on each image

    Given user is on the "/hovers" page
    When user does a mouse hover on each image
    Then verify that additional information is displayed for each image