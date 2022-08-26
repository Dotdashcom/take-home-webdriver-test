Feature: User wants hover over picture to see additional information 
    Scenario:  User wants hover over picture to see additional information
        Given the user is on the file MouserHover page
        When Test does a mouse hover on each image
        Then Test asserts that additional information is displayed for each image