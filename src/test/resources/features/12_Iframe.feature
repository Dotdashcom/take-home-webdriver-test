@Iframe
Feature: The scenarios for the Iframe page

  Background: 
    Given navigate to the 'iframe' page

  @testIframe
  Scenario: Test Iframe
  	And switch to Iframe and types some text
    Then verify that the typed text is as expected



