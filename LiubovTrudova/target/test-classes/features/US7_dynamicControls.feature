Feature: Dynamic Controls functionality

  Background: navigate to Dynamic Controls
    Given click on Dynamic Controls link

    Scenario: verify Dynamic Controls work as expected
      Given clicks on the Remove Button
      When asserts that the checkbox is gone
      Then clicks on Add Button
      Then asserts that the checkbox is present
      And clicks on the Enable Button
      And asserts that the text box 'It's enabled!'
      And clicks on the Disable Button
      Then  asserts that the new text box "It's disabled!"

