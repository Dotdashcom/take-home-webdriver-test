@DynamicContent
Feature: The scenarios for the Dynamic Content page

  Background: 
    Given navigate to the 'dynamic_content' page

  @testDynamicContent
  Scenario: Test Dynamic Content
    Then refresh page 5 times and verify the content changes on each refresh

