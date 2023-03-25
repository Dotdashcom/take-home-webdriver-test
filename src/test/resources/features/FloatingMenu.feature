Feature: Floating Menu

  @Test @nor
  Scenario: Test the floating menu still appear after scrolling the page down

    Given user in "floating_menu" page
    Then verify Floating menu displayed at the top of page
    And scroll the page down by <800> pixels
    Then verify Floating menu displayed at the top of page
    And scroll the page down by <800> pixels
    Then verify Floating menu displayed at the top of page
    And scroll the page down by <800> pixels
    Then verify Floating menu displayed at the top of page