Feature: Iframe

@Test
Scenario:  Working with Iframe

  Given I am on the Iframe page
  When I switch to Iframe and type some text
  Then I verify that the typed text is as expected


