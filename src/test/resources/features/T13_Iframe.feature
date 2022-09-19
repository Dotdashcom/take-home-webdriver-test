
Feature: Test Iframe

  Scenario: Verify that the typed text is as expected when user switches to Iframe and types some text

    Given user is on the "/iframe" page
    When user types on the text box on the page
    Then verify that the typed text is as expected