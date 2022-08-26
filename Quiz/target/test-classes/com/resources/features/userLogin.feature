Feature: User is able to login with given credentials

    Scenario: As a user I want to log in so I can use the service
        Given the user is on the log-in page
        When the user enters correct username
        When the user enters correct password
        When the user clicks on the log-in button 
        Then the user will be redirected to the homepage

    Scenario: As system I want to validate log-in credentials
        Given the user is on the log-in page
        When the user enters wrong username
        When the user enters wrong password
        When the user clicks on the log-in button 
        Then error message will be displayed
