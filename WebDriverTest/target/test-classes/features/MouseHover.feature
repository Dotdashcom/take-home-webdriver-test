#Author: Andrei Shelekhov shelekhovandrei@gmail.com
Feature: Mouse Hover

  Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.

  Scenario: Mouse Hover

    Given user is on the Page "http://localhost:7080/hovers"
    When user hovers on every users avatar

    Then user sees additional information under Avatar
      | user1 |
      | user2 |
      | user3 |

    When user clicks on the profile link

    Then user sees message "Sinatra doesn’t know this ditty."