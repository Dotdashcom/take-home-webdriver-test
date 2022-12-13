Feature: User should be failed to login with incorrect credentials

  Background:
    Given user is on the BaseUrl login page

  @Login_negative1
  Scenario: negative scenario wrong username/password
    When user enters below credentials and click login button
      | username | Test   |
      | password | SuperSecretPassword! |
    Then user should see negative username message "Your username is invalid!"

  @Login_negative2
  Scenario: negative scenario wrong password
    When user enters below credentials and click login button
      | username | tomsmith   |
      | password | Tester |
    Then user should see negative password message "Your password is invalid!"

  @Login_negative3
  Scenario: negative scenario wrong username/password
# scenario wrong both username/password appear to "scenario wrong username"