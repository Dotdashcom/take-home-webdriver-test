Feature: Download File
  @Test
  Scenario: user Should be able to download file
    Given User navigate to the file Download URL
    Then user click on the filr "some-file.txt" to TestData folder under resources
    Then user close driver