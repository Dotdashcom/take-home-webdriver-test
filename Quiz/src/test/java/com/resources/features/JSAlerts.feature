Feature: User is going to use differnt js alerts to test page
    Scenario: User is going to use differnt js alerts to test page
        Given the user is on the homepage page for Alerts
        When Test Clicks on JS Alert Button
        When Test asserts alert message
        When Test clicks on JS confirm Button and clicks ok on alert
        When Test asserts the alert message
        When Test clicks on JS Prompt Button and types a message on Prompt
        Then Test asserts that the alert message contains the typed message