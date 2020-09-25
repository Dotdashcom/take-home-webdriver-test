@TestAll
Feature: JS Error

  @Test16
  Scenario: JS Error
    Given User on JS Error page
    When User finds the JavaScript error on the page
    Then assert that the page contains error: "Cannot read property 'xyz' of undefined".