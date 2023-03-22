@OpenInNewTab
Feature: The scenarios for the Open In New Tab page

  Background: 
    Given navigate to the 'windows' page

  @testOpenInNewTab
  Scenario: Opening a new window
    And click on the Click Here link
    Then verify that a new tab is opened with text 'New Window'

