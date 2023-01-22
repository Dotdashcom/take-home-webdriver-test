Feature: User is not able to logIn with invalid Username and password
  @Test
  Scenario Outline: Failure LogIn
    Given User Navigate to the URL
    And user enter invalid "<username>" username and "<password>" password then click on login Button
    Then user should be able to verify "<errorMessage>" error message
    Examples:
      | username        | password             | errorMessage              |
      | tomsmith        | invalidPassword      | Your password is invalid! |
      | invalidUsername | SuperSecretPassword! | Your username is invalid! |
      |                 | SuperSecretPassword! | Your username is invalid! |
      | tomsmith        |                      | Your password is invalid! |
      |                 |                      | Your username is invalid! |
      | invalidUsername | InvalidPassword      | Your username is invalid! |

