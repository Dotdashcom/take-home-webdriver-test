Feature: User wants to be able type in iframe
    Scenario: User wants to be able type in iframe
        Given the user is on the file iframe page
        When Test switches to Iframe and types some text
        Then Test asserts that the typed text is as expected



