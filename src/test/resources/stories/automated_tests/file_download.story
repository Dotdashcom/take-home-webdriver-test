Meta:
@fileDownload
@InProgress

Scenario: File Download
Meta:
@fileDownload
Given the user is in home page
When the user navigate to 'download'
When the user click on the file to download
Then file is downloaded successfully