Feature: User is going load a dynamic page
    Scenario: User is going load a dynamic page 
        Given the user is on the page for dynamic loading 
        When Test clicks the start button and uses explicit wait
        Then Test asserts that “Hello World!” text is displayed.