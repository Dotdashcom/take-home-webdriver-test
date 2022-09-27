@Test
Feature: Dynamic Controls Feature
  Verify user is able to interact with dynamic controls page

  Scenario: Click on remove button
    Given user navigates to dynamic controls page
    When user clicks on remove button
    Then checkbox is not present

  Scenario: Click on add button
    Given user navigates to dynamic controls page
    When user clicks on remove button
    And user clicks on add button
    Then checkbox is present

  Scenario: Click on enable button
    Given user navigates to dynamic controls page
    When user clicks on enable button
    Then text box is enabled

  Scenario: Click on disable button
    Given user navigates to dynamic controls page
    When user clicks on enable button
    And user clicks on disable button
    Then text box is disabled