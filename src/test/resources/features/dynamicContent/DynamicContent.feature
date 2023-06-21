@DynamicContent
Feature: DynamicContent
    #JIRA_ID - JIRA_009

  Scenario: Verify Dynamic Content features
    Given the user is on example home page
    When the user click on dynamic content page
    Then the use should see the dynamic content page
    When the user clicks on the "click here" link on the dynamic content page
    Then the user should see the page is refreshed on the dynamic content page
    When the user clicks on the "click here" link on the dynamic content page
    Then the user should see the page is refreshed on the dynamic content page
    When the user clicks on the "click here" link on the dynamic content page
    Then the user should see the page is refreshed on the dynamic content page
