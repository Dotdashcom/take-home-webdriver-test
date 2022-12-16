Feature: File Iframe Functionality Test

  @Test
  Scenario: Iframe funcionality
    Given I navigated to Iframe website
    Then I  switches to Iframe and types some text
    And assert that the typed text is as expected
    And I quit the browser
