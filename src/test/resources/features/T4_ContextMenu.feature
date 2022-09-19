
Feature: Test Context Menu

  Scenario: Test right clicks on the context menu then verify the alert menu text.
    Given user is on the "/context_menu" page
    When user right click on the box
    Then verify JavaScript alert text