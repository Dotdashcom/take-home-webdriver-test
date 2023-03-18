Feature: Downloading file

  @Test @wip
    Scenario: test downloading the file

    Given user in "download" page
    When user clicks on filename "some-file.txt"
    Then verify that file is downloaded