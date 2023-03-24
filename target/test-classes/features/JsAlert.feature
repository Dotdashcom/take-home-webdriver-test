Feature: JavaScript Alerts

  @Test @nor
  Scenario: Test JS Alerts

    Given user in "javascript_alerts" page
    When user "Click for JS Alert" Button
    Then verify alert message "I am a JS Alert"
    When user "Click for JS Confirm" Button and clicks ok on alert
    Then verify alert message "I am a JS Confirm"
    When user "Click for JS Prompt" Button and types "this message" on Prompt
    Then verify that the alert message contains the typed message