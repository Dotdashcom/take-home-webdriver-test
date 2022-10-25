@iFrame
Feature: iFrame Test

  @Test
  Scenario: Switch to Iframe and types some text and assert that the typed text is as expected
    Given user is on "/iframe" iframe page
    When user switches to iFrame and types random text
    Then user should be able to assert expected and actual texts