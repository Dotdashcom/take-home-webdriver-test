Feature: Downloading file

  @Test @withOption @tt
    Scenario: test downloading the file

    Given user is in "download" page
    When user clicks on filename "some-file.txt"
    Then verify that file is downloaded