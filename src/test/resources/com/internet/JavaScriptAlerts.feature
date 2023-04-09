Feature: JS Alerts Ops

  @Test
  Scenario: As a User I want to be able to observe JS alerts
    Given User is on Landing page
    And User clicks on "JavaScript Alerts" submenu
    When User clicks on JS Alert Button
    Then User observes that alert popup is displayed with the message "I am a JS Alert"
    When User clicks on JS Confirm Button
    Then User observes that alert popup is displayed with the message "I am a JS Confirm"
    When User clicks on JS prompt Button
    Then User text into prompt "Hello World"
    Then User verifies that entered text is in result
