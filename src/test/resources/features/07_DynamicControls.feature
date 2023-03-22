@DynamicControls
Feature: The scenarios for the Dynamic Controls page

  Background: 
    Given navigate to the 'dynamic_controls' page

  @testDynamicControls
  Scenario: Test Dynamic Controls
    And click on the Remove button
    Then verify that the checkbox is gone
    And click on Add button
    Then verify that the checkbox is present
    And click on the Enable button
    Then verify that the text box is enabled
    And click on the Disable button
    Then verify that the text box is disabled