@JavaScriptAlerts
Feature: JavaScriptAlerts
    #JIRA_ID - JIRA_018

  Scenario: Verify JavaScript Alerts
    Given the user is on example home page
    When the user clicks on the JavaScript Alerts page
    Then the user should see the JavaScript Alerts page
    When the user clicks on the "Click for JS Alert" on the JavaScript Alerts page
    Then the user should see the alert message "I am a JS Alert" on the JavaScript Alerts page
    Then the user should see event confirmation message "You successfuly clicked an alert" on the JavaScript Alerts page
    When the user clicks on the "Click for JS Confirm" on the JavaScript Alerts page
    Then the user should see the alert message "I am a JS Confirm" on the JavaScript Alerts page
    Then the user should see event confirmation message "You clicked: Ok" on the JavaScript Alerts page
    When the user clicks on the "Click for JS Prompt" on the JavaScript Alerts page
    When the user enters "test msg" on the JavaScript prompt on the JavaScript Alerts page
    Then the user should see event confirmation message "You entered: test msg" on the JavaScript Alerts page




