Feature: Context Menu functionality
Background: navigate to Context Menu
  Given click Context Menu link

  Scenario: perform right click
    Given perform context click
    When switch to alert and accept it
    Then verify page is reachable