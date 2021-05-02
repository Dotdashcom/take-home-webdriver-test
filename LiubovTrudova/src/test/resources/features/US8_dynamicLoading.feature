Feature: Dynamic Loading functionality

  Background: navigate to Dynamic Loading
    Given navigate to Dynamic Loading "http://localhost:7080/dynamic_loading/1"

    Scenario: verify Dynamic Loading works as expected
      Given click Start button
      Then asserts that the message is "Hello World!"