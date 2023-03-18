Feature: Dynamic Loader

  @Test
    Scenario: test Dynamic Loader
    Given user in "dynamic_loading/2" page
    When user clicks on start button
    Then user must see "Hello World!" on the screen