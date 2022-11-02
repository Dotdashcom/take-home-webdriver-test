@UI
Feature: Testing JavaScript Alerts

  Scenario Outline: Testing JavaScript Alert

    Given I navigate to the JavaScript Alerts Page
    When I click on the JS Alert
    Then An alert should appear "<alert>"
    And I should click OK
    And the result should change to "<result>"

    Examples:
      | alert           | result                           |
      | I am a JS Alert | You successfuly clicked an alert |

  Scenario Outline: Testing JavaScript Confirm

    Given I navigate to the JavaScript Alerts Page
    When I click on the JS Confirm
    Then An alert should appear "<alert>"
    And I should click "<button>"
    And the result should change to "<result>"

    Examples:
      | alert             | button | result              |
      | I am a JS Confirm | Ok     | You clicked: Ok     |
      | I am a JS Confirm | Cancel | You clicked: Cancel |

  Scenario Outline: Testing JavaScript Prompt

    Given I navigate to the JavaScript Alerts Page
    When I click on the JS Prompt
    Then An alert should appear "<alert>"
    And I should write some "<text>"
    And I should click "<button>"
    And the result should change to "<result>"

    Examples:
      | alert             | text             | button | result                        |
      | I am a JS prompt  | Selenium Testing | Ok     | You entered: Selenium Testing |
      | I am a JS prompt  | Selenium Testing | Cancel | You entered: null             |