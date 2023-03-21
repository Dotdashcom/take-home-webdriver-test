Feature: Dynamic Controls

  @Test @nor
  Scenario: test Dynamic Controls

    Given user in "dynamic_controls" page
    When user clicks on the Remove Button
    Then verify that the checkbox is gone
    When user clicks on Add Button
    Then verify that the checkbox is present
    When clicks on the Enable Button
    Then verify that the text box is enabled
    When clicks on the Disable Button
    Then verify that the text box is disabled