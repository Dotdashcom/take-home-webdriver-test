Feature: Mouse Hover
  @Mouse
  @Test
  Scenario: Test does a mouse hover on each image.
  Test asserts that additional information is displayed for each image.
    Given User goes to the Mouse Hover page
    When User can does mouse hover on each image
    Then  User can see Additional information is displayed for each image.