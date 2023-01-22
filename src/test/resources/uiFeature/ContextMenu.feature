Feature: user should right click on the box
  @test
  Scenario: User should be able to right click on the box
    Given user navigate to the check menu URL
    Then user right click on the contextmenu
    Then User validate message on the alert then click Ok
    Then User close driver