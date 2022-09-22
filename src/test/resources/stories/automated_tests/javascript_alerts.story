Meta:
@javascriptAlerts

Scenario: Javascript Alerts
Meta:
@javascriptAlerts
Given the user is in home page
When the user navigate to 'javascript_alerts'
Then 'I am a JS Alert' text should be displayed on Alert upon click on 'Click for JS Alert'
Then 'I am a JS Confirm' text should be displayed on Alert upon click on 'Click for JS Confirm'
Then 'I am a JS prompt' text should be displayed on Alert upon click on 'Click for JS Prompt'
When user enter text on JS prompt upon click on 'Click for JS Prompt'
Then text should be entered successfully