Feature: Dynamic Page Load functionality
  @Test
  Scenario: Dynamic Page Load functionality click on start
    Given User should be able to navigate to the DynamicPage URL
    Then user should be able to click on Start Button and verify message "Hello World!"
    Then user close the driver