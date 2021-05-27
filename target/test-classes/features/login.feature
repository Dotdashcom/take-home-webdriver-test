Feature: Login


  Scenario: User should be be able to login successfully

    Given User on login page
    When User enters valid username and password
    Then user should landing on home page and see "You logged into a secure area!"


 Scenario: User should be able to logout Successfully

   Given User in home page
   When user clicks logout button
   Then User should successfully logout and see "You logged out of the secure area!"

   Scenario: User should not be able to login with invalid credentials

     Given User on login page
     When User enters invalid username
     And User enters valid password
     Then User should see "Your username is invalid!"


  Scenario: User should not be able to login with invalid credentials

    Given User on login page
    When User enters valid username
    And User enters invalid password
    Then User should see "Your password is invalid!"

