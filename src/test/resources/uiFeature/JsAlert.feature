Feature: javaScript Alert Functionality

  @Test
  Scenario: user should be able to interact with JavaScript Alert
    Given User should be able to Navigate to the Js Alert URL
    Then User click on the Click for JS Alert
    Then User verify text in alert and click on Ok butten


  @Test
  Scenario: user should be able to interact with Click for JS Confirm
    Given User should be able to Navigate to the Js Alert URL
    Then User Click for JS Confirm
    Then User should verify text in alert and click on Ok butten

  @Test
    Scenario: User should be able to interact with Prom button
      Given user click on the prom button and send message "Hello World!" and do verification

