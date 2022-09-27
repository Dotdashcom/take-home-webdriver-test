@Test
Feature: JS Alert Feature
  Verify JS Alert buttons are working

  Scenario: Click on JS alert button
    Given user navigates to JS alert page
    When user clicks on JS alert button
    Then JS alert message is displayed

  Scenario: Click on JS confirm button
    Given user navigates to JS alert page
    When user clicks on JS confirm button
    Then JS confirm message is displayed

  Scenario: Click on JS prompt button
    Given user navigates to JS alert page
    When user clicks on JS prompt button
    And user enters text in JS prompt alert
    Then JS prompt alert contains expected text