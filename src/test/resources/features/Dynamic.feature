Feature: test dynamic content

  @Test @wip
    Scenario: Test refreshes the page a couple of times

    Given user in "dynamic_content" page
    When user must see <3> paragraph of text
    And user does refresh the page <3> times each time content must change