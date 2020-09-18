Feature: Log in 
Background:
Given I am on the homepage 

@Test
Scenario: Login Success  
When I enter username  "tomsmith" and password "SuperSecretPassword!"
Then I varify welcome message 

@Test
Scenario: Login Faile
When I enter invalid  username  "tomhanks" and password "SuperSecretPasswordInvalid!"
Then I varify  message for invalid log in entry
