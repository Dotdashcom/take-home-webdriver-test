#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Login

  Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
  Login Failure: http://localhost:7080/login Login fail invalid credentials

  Background:
    Given user is on the Page "http://localhost:7080/login"

  Scenario Outline: Login with valid credentials
    When user enters valid "<Username>" and "<Password>" and clicks on login button
    Then user is on "Secure Area" and see "<SuccessfulLoginMessage>"
    Examples:
      | Username | Password             | SuccessfulLoginMessage         |
      | tomsmith | SuperSecretPassword! | You logged into a secure area! |

  Scenario Outline: Error message validation while invalid login
    When user enters invalid "<Username>" and "<Password>" and clicks on login button
    Then user sees "<errorMessage>" is displayed

    Examples:
      | Username | Password             | errorMessage              |
      | invalid  | SuperSecretPassword! | Your username is invalid! |
      |          | SuperSecretPassword! | Your username is invalid! |
      |          |                      | Your username is invalid! |
      | tomsmith | invalid              | Your password is invalid! |
      | tomsmith |                      | Your password is invalid! |