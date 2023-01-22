Feature: Click on the link and new Tab open
  @Test
  Scenario: user click on the link and new Tab open
    Given user navigate to the targer URl
    Then user click on the click here link to open new Tab
    Then user see message "New Window" and verify the message user navigate to the main UR
