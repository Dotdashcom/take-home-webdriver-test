@Test
Feature: IFrame Feature
  Verify IFrame is working

  Scenario: Inputting text into iframe
    Given user navigates to iframe page
    When user inputs some text in iframe content body
    Then iframe content body contains expected text