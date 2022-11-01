@test2
  Feature: Context Menu


    Background: User is already in Context Menu page
      Given user is on the Context Menu page

Scenario:Test right clicks on the context menu.
Test asserts the alert menu text.

  When user do the right clicks
  Then Alert popped up