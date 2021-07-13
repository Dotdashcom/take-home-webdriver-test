@LoginFailure @All
Feature: Login_Failure

  Scenario Outline: Login_Failure
	Given I navigate to url "http://localhost:7080/login"
	And   I enter username as "<username>"
 	And   I enter password as "<password>"
   	When  I click Login
   	Then  I should not be logged into the system and system should popup message "<message>"
   	
  Examples:
  |username|password|message                   |
  |abc     |xyz     |Your username is invalid! |
  |tomsmith|lmn     |Your password is invalid! |
	
     
       