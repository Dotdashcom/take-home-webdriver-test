Feature: Login feature

  @Test @nor
  Scenario: Login with valid credentials

    Given user in "login" page
    When user enters valid credentials
    Then user should see "You logged into a secure area!" message

  @Test
  Scenario: Login with invalid credentials

    Given user in "login" page
    When user enters invalid credentials
    Then user should see "Your username is invalid!" message