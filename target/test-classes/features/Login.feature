@test
Feature:Login  feature
  As a user, I should be able to login with correct credential
  As a user, I should fail to log in with wrong credential

  Background: User is already in login page
    Given user is on the login page

    Scenario: Login with correct credential
    When user enters correct username
    And user enter correct password
    Then logged in successfully


      Scenario: Login with wrong credential
        When user enters wrong username
        And  user enter wrong password
        Then failed login



