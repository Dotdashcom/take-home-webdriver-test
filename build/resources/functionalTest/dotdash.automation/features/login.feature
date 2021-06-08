Feature: Login

  Scenario: Test Login Success
    Given I navigate to login "login" page
    And I enter username "tomsmith" and password "SuperSecretPassword!"
    When I click on login button
    Then I should login successfully and see Secure page
