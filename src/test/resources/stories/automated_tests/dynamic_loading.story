Meta:
@dynamicLoading

Scenario: Dynamic Loading
Meta:
@dynamicLoading
Given the user is in home page
When the user navigate to 'dynamic_loading/2'
And user click on Start button
And user wait for loading to complete
Then 'Hello World!' message should be displayed