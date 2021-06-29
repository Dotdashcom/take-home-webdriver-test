@regression
  Feature: Context Menu
    Background: user is on the checkbox page

    Scenario:Test right clicks on the context menu.
    Test asserts the alert menu text.

      Given user is on the Context Menu page
      When user do the right clicks
      Then Alert popped up