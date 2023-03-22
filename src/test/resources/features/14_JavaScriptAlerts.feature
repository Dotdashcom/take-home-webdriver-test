@JavaScriptAlerts
Feature: The scenarios for the JavaScript Alerts page

  Background: 
    Given navigate to the 'javascript_alerts' page

  @testJavaScriptAlerts
  Scenario: Test JavaScript Alerts
    And click on JS Alert button and accept alert
    Then verify alert message
    And click on JS confirm button and click ok on alert
    Then verify new alert message
    And click on JS Prompt button and type a message on Prompt
    Then verify that the alert message contains the typed message
