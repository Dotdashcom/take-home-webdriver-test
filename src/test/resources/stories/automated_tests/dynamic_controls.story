Meta:
@dynamicControls

Scenario: Dynamic Controls
Meta:
@dynamicControls
Given the user is in home page
When the user navigate to 'dynamic_controls'
And user click on Remove button
And user wait for completion of async command
Then Add button should be displayed
And success message should be displayed