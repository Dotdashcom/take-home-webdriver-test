Feature: User should be failed to login with incorrect credentials

  Background:
    Given user is on the BaseUrl login page

  @Login_negative
  Scenario: negative scenario wrong username
    When user enters below credentials
      | username | Test   |
      | password | SuperSecretPassword! |
    And user click login button
    Then user should see negative username message "Your username is invalid!"

  @Login_negative
  Scenario: negative scenario wrong password
    When user enters below credentials
      | username | tomsmith   |
      | password | Tester |
    And user click login button
    Then user should see negative password message "Your password is invalid!"