@Test
Feature: Mouse Hover Feature
  Verify mouse hover displays user caption

  Scenario: Mouse hover over user one's image
    Given user navigates to mouse hover page
    When user hovers mouse cursor over user "1" image
    Then user "1" caption is displayed

  Scenario: Mouse hover over user two's image
    Given user navigates to mouse hover page
    When user hovers mouse cursor over user "2" image
    Then user "2" caption is displayed

  Scenario: Mouse hover over user three's image
    Given user navigates to mouse hover page
    When user hovers mouse cursor over user "3" image
    Then user "3" caption is displayed