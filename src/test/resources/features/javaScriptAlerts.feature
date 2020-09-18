Feature: JavaScript Alerts

@Test
Scenario: Working with JavaScript Alerts

  Given I am on the JavaScript Alerts  page
  When I click on JS Alert Button
  Then I verify alert message
  When I click on JS confirm Button and click ok on alert
  Then I verify the alert message
  When I click on JS Prompt Button and type a message on prompt
  Then I verify that the alert message contains the typed message.



