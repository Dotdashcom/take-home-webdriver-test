@DynamicLoading
Feature: The scenarios for the Dynamic Loading page

  Background: 
    Given navigate to the 'dynamic_loading/2' page

  @testDynamicLoading
  Scenario: Test Dynamic Loading
  	And click the start button
    Then verify that 'Hello World!' text is displayed



