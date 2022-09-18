
Feature: Test Dynamic Content

  Scenario: Verify that the content changes on each refresh in couple of time

    Given user is on the "/dynamic_content" page
    When user refresh the page
    Then verify that the content changes on each refresh