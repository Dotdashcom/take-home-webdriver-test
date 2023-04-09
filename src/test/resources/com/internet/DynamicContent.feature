Feature: Dynamic Content Operation

  @Test
  Scenario: As a User I want to be able to see different content when I refresh web page
    Given User is on Landing page
    And User clicks on "Dynamic Content" submenu
    And User refresh the web page
    Then User verifies the content of the page is changed
