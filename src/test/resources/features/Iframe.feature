Feature: Iframe

  @Test @nor
    Scenario: Test switches to Iframe and types some text.

    Given user in "iframe" page
    When user types "something" on text box
    Then verify the text is displayed as expected
