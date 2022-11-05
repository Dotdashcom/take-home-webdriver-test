Feature: Notification Message
@Notification
@Test
  Scenario: Test clicks on the Click Here link a multiple times.
  Test asserts that one of the “Action Successful”, “Action unsuccessful, please try again”
  and “Action Unsuccessful” messages show on click.
    Given User goes to  the Notification Message Page
    When User clicks on the Click Here link a multiple times
