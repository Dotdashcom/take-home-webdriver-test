Feature:Login Success
  User should be able to login with correct credential
  @Login
  @Test
  Scenario: Login with correct credential
    When User goes to login page
    Then User enters correct username-password
    And User clicks on login
    Then logged in successfully




