Feature: Open in new Tab

  @Test @nor
  Scenario: Open the link in new tab

    Given user in "windows" page
    When user clicks on "Click Here" link
    Then verify the link will be open in new tab
      | New Window |