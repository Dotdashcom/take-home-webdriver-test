Feature: Login Functionality
 
    @Test
    Scenario: Valid Login
    Given I navigated to website
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in
    And I quit the browser
    
    @Test
    Scenario: Invalid Password
    Given I navigated to website
    When I enter a valid username
    And I enter a invalid password
    And I click on the login button
    Then I validate that Invalid credentials message is displayed
    Then I will quit the browser
    
    @Test
    Scenario: Invalid Username
    Given I navigated to website
    When I enter a invalid username
    And I enter a valid password
    And I click on the login button
    Then I validate that Invalid Username message is displayed
    Then I will quit the browser