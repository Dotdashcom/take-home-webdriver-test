Meta:
@loginSuccess

Scenario: Verify Login Success
Meta:
@loginSuccess
Given the user is in home page
When the user navigate to 'login'
When the user enter valid username
And the user enter valid password
And the user click on login
Then login should be successful