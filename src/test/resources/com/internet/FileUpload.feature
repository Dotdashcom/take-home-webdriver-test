Feature: File Upload Operation

  @Test
  Scenario: As a User I want to be able to upload a file
    Given User is on Landing page
    And User clicks on "File Upload" submenu
    When User select file to be uploaded
    Then User verifies that file is uploaded
