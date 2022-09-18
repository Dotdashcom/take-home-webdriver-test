
  Feature: Test Dropdown

   Scenario: Verify Option 1 and Option 2 are selected

     Given user is on the "/dropdown" page
     When user clicks on the dropdown option
     Then verify user select option one
     And verify user select option two