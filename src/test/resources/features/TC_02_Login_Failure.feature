Feature:Login Failure
  User should fail to log in with wrong credential
  @Failure
  @Test
  Scenario: Login with wrong credential
    When User goes to the login page
    When user enters wrong username-password
    And  User clicks on login button
    Then failed login
