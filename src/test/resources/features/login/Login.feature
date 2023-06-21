@Login
  Feature: Login
    #JIRA_ID - JIRA_002
    #JIRA_ID - JIRA_003
    #JIRA_ID - JIRA_004

  Scenario: Login Successful
    Given the user is on example home page
    When the user clicks on login button on the homepage
    When the user enters username as "tomsmith" on the login page
    When the user enters password as "SuperSecretPassword!" on the login page
    When the user enters on the login button on the login page
    Then the user should see the secure page

    Scenario: Login Failure - Invalid Username
      Given the user is on example home page
      When the user clicks on login button on the homepage
      When the user enters username as "testUser" on the login page
      When the user enters password as "testPwd" on the login page
      When the user enters on the login button on the login page
      Then the user should see invalid username error on the login page

    Scenario: Login Failure - Invalid Password
      Given the user is on example home page
      When the user clicks on login button on the homepage
      When the user enters username as "tomsmith" on the login page
      When the user enters password as "testPwd" on the login page
      When the user enters on the login button on the login page
      Then the user should see invalid password error on the login page

