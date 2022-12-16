Feature:  File Download Functionality Test
 
    @Test
    Scenario: File Download funcionality
    Given I navigated to File Download website
    Then I clicks on the file
    And I asserts that the file is downloaded.
    And I quit the browser