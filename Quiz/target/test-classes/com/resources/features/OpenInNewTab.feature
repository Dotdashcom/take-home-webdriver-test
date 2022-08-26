Feature: User wants to make sure the redirect opens new tab
    Scenario:  User wants to make sure the redirect opens new tab
        Given the user is on the opennewtab page
        When Test clicks on the Click Here link
        Then Test asserts that a new tab is opened with text New Window