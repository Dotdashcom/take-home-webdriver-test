Feature: Drag and Drop functionality

  Scenario:verify Drag and Drop functionality works as expected
    Given navigate to Drag and Drop
    Then Drag and Drop boxA to boxB, verify text inside boxes been changed
