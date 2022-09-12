Feature: TakeHome Tests

@takeHome1
Scenario: Login Page w/valid credentials
Given I navigate to "take-home" page
When I fill out required fields with valid creds
And I click login button
Then I verify login is successful

@takeHome2
Scenario: Login Page w/invalid credentials
Given I navigate to "take-home" page
When i fill out required fields with invalid creds
And I click login button
Then I verify login is not successful

@takeHome3
Scenario: Checkboxes test
Given I navigate to "take-home" page
When I "select" all checkboxes
Then I verify all checkboxes are selected
When I "unselect" all checkboxes
Then I verify all checkboxes are unselected

@takeHome4
Scenario: Context Menu test
Given I navigate to "take-home" page
When I right-click context menu
Then I verify JavaScript alert is triggered

@takeHome5
Scenario: Dropdown test
Given I navigate to "take-home" page
When I select "Option 1" from the dropdown menu
Then I verify "Option 1" is selected

@takeHome6
Scenario: Drag and Drop test
Given I navigate to "take-home" page
When I drag element A to element B
Then I verify that the text on element A and B are switched

@takeHome7
Scenario: Dynamic Content test
Given I navigate to "take-home" page
When I refresh the page
Then I verify that content is changed

@takeHome8
Scenario: Dynamic Controls test
Given I navigate to "take-home" page
When I click on the Remove Button and use explicit wait
Then I verify that the checkbox is gone
When I click on Add Button and use explicit wait
Then I verify that the checkbox is present
When I click on the Enable Button and use explicit wait
Then I verify that the text box is enabled
When I click on the Disable Button and use explicit wait
Then i verify that the text box is disabled




