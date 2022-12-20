@regression
Feature: QA Assignments

  Scenario: login successfully
    Given I am on the login page
    When I login with valid credentials
    Then I should be able to login successfully

  Scenario:  login with wrong credentials
    Given I am on the login page
    When I login with invalid credentials
    Then I should not be able to login

  Scenario:  Checkboxes
    Given I am on the checkboxes page
    When I select checkbox 1
    Then Checkbox 1 should be selected
    When I unselect checkbox 2
    Then Checkbox 2 should be unselected

  Scenario:  Context Menu
    Given I am on the context_menu page
    When I right clicks on the context menu
    Then I assert the alert menu text

  Scenario:  Drag and Drop
    Given I am on the drag_and_drop page
    When I drag element A to element B
    Then I assert that the text on element A and B are switched

  Scenario:  Dropdown
    Given I am on the dropdown page
    When I select 'Option 1' from the drop down menu
    Then I assert 'Option 1' are selected

  Scenario:  Dynamic Content
    Given I am on the dynamic_content page
    When I refresh the page
    Then I assert that the content changes on refresh
    When I refresh the page
    Then I assert that the content changes on refresh




