Feature: User login in
Background: For each scenario user is on login page
  Given user on login page
  @Test
  Scenario: User should successfully login with valid credentials
    And user use valid credentials for login
    Then user should see page with massage about successful login
  @Test
  Scenario: User is not able to login with wrong credentials
    When user use invalid credentials for login
    Then user should see notice about failed login