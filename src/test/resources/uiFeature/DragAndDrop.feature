Feature: Drag and Drop
  @test
  Scenario: User should be able to do Drag and Drop action
    Given User navigate to the Drag and Drop URL
    Then User drag elemnt A to the place of elemnt B
    Then user verified the changes of Drag and Drop
    Then user close the URL