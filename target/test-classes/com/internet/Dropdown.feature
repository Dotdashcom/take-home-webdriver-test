Feature: Dropdrop operations


  Scenario: As a User I want to be able to use dropdown to select option1 and option2
      Given User is on Landing page
      And User clicks on "Dropdown" submenu
      And User selects "Option 1" from the dropdown
      Then User verifies that "Option 1" is selected
      And User select "Option 2" from the dropdown
      Then User verifies that "Option 2" is selected
