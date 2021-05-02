Feature: Dynamic Content functionality

  Scenario: verify that content is dynamic
    Given navigate to Dynamic Content
    Then asserts that the content changes on each refresh.
