
@Test
Feature: Dynamic Content Page

  Scenario: Validate content is changing when page is refreshed
    Given I navigate to the page and get the content
    Then I refresh the page and validate content is changed
 
