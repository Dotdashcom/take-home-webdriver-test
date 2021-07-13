@LoginSuccessful @All
Feature: Login_Successful

  Scenario: Login_Successful
	Given I navigate to url "http://localhost:7080/login"
	And   I enter username as "tomsmith"
 	And   I enter password as "SuperSecretPassword!"
   	When  I click Login
   	Then  I should be logged into the system
	
     
       