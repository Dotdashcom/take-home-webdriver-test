@login @smoke
Feature: User checks positive and negative login tomsmith/SuperSecretPassword!

  Background:
    Given User on the login page

  @success
  Scenario: Login success
    When User enter credentials
    Then User should see success message - "You logged into a secure area!"


  @fail
  Scenario Outline: Login failure
    When User enter "<username>" and "<password>"
    Then User should see failure message - "<message>"

    Examples:
      | username      | password             | message                   |
      | tomsmith      | wrongpassword        | Your password is invalid! |
      | wrongusername | SuperSecretPassword! | Your username is invalid! |
      | wrongusername | wrongpassword        | Your username is invalid! |



