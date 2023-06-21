@IFrame
Feature: IFrame
    #JIRA_ID - JIRA_015

  Scenario: Verify IFrame
    Given the user is on example home page
    When the user clicks on the frame page
    Then the user should see the frame page
    When the user clicks on the Iframe page
    Then the user should see the iframe page
    When the user switches to "mce_0_ifr" on the Iframe page
    When the user type "test iframe" on the current iframe textbox on the Iframe page
    Then the user should not see the text "test iframe" on the default iframe on the Iframe page
    Then the user should see the text "test iframe" on the iframe "mce_0_ifr" on the Iframe page


