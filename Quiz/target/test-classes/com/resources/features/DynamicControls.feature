Feature: User is going to use differnt dynamic controls with explict waits
    Scenario: User is going to use differnt dynamic controls with explict waits
        Given the user is on the homepage page for Dynamic Controls
        When Test clicks on the Remove Button and uses explicit wait
        When Test asserts that the checkbox is gone
        When Test clicks on Add Button and uses explicit wait.
        When Test asserts that the checkbox is present 
        When Test clicks on the Enable Button and uses explicit wait
        When Test asserts that the text box is enabled
        When Test clicks on the Disable Button and uses explicit wait
        Then Test asserts that the text box is disabled