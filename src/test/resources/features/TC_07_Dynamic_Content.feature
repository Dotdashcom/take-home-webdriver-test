Feature: Dynamic Content
  @DynamicContent
  @Test
  Scenario: Test refreshes the page a couple of times.
  Test asserts that the content changes on each refresh.
    Given User goes to the Dynamic content page
    When User clicks on the click here for Dynamic content changes
    Then User can see content changes on each refresh