Feature: Iframe functionality


  Scenario: verify Iframe functionality works as expected
    Given navigate to "http://localhost:7080/iframe"
    When navigate to Iframe type "some text"
    Then  verify "some text" is presented