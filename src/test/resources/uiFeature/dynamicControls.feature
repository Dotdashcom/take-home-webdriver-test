Feature: Check dynamic Element in the page
  @Test
  Scenario: User check  remove and add button functionality
    Given User Navigate to dynamic Controls URL
    Then user click on the Remove button to remove checkBox from page and verify the message "It's gone!"
    Then user click on the add butten and verify the message "It's back!"
    Then user clsoe driver





  @Test
    Scenario: user should be able to enable and disable textBox
      Given Uer should be able to Navigate to the dynamic Control URl
      Then User should be able to click on the enable button to enable the input box and verify message "It's enabled!"
      Then user should be able to click again to disable the butten and verify messsage  "It's disabled!"
      Then user clsoe driver

