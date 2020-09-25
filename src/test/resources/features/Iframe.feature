@TestAll
Feature: iFrame

  @Test13
  Scenario: iFrame
    Given User on iFrame page
    When switches to iFrame and types some text
    Then the typed text is as expected