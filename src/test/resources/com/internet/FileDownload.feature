Feature: File Download Operation

  @Test
  Scenario: As a User I want to be able to download a file
    Given User is on Landing page
    And User clicks on "File Download" submenu
    When User clicks on link to download the file
    Then User verifies that file is downloaded
