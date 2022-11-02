@UI
Feature: Download File

  Scenario: Download File

    Given I navigate to the Download Page
    When I click on the download button
    Then The file should be downloaded
