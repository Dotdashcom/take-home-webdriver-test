Feature: Cheking the dynamic changes of text and photo
  @Test
  Scenario: user should be able refresh the page and see changes
    Given user navigate to the Dynamic Content URL
    Then user click on the click here link to make changes
    Then user veriffy the changes of photo and text
    Then user close the browser