Feature: HoverOver Functionality

  @Test
  Scenario: User should be able to Hoverover on 3 image and see info
    Given user navigate  HoverOver URL
    Then user hover over on images to check users
      | users       |
      | name: user1 |
      | name: user2 |
      | name: user3 |


