Meta:
@loginFailure

Scenario: Verify Login Failure
Meta:
@loginFailure
Given the user is in home page
When the user navigate to 'login'
When the user enter valid username
And the user enter invalid password
And the user click on login
Then invalid password error should be displayed