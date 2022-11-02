@UI
Feature: iFrame

  Scenario: Testing the iFrame

    Given I navigate to the iFrame Page
    When I write into the text area
    And Apply bold, align right and change font size
    And I write into the text area again
    Then The changes should be made