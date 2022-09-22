Meta:
@fileUpload
@InProgress

Scenario: File Upload
Meta:
@fileUpload
Given the user is in home page
When the user navigate to 'upload'
When user upload the file
And the user click on Upload button
Then file uploaded successfully message should be displayed