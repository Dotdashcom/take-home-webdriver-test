@UI
Feature: Login

  Scenario Outline: Login Success

    Given I navigate to the Login Page
    When I enter "<user>" and "<password>" as credentials
    Then I should see the success "<message>"

    Examples:

    | user          | password             | message                        |
    | tomsmith      | SuperSecretPassword! | You logged into a secure area! |

  Scenario Outline: Login Failed Scenarios

    Given I navigate to the Login Page
    When I enter "<user>" and "<password>" as credentials
    Then I should see the failed "<message>"

    Examples:

      | user          | password             | message                        |
      |               |                      | Your username is invalid!      |
      | tomsmith      | WRONG PASSWORD       | Your password is invalid!      |
      | WRONGUSERNAME | SuperSecretPassword! | Your username is invalid!      |