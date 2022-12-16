Feature:File Upload Functionality Test
 
    @Test
    Scenario: File Upload funcionality
    Given I navigated to File Upload website
    Then I test uses Upload Button  
    And I assert that the file is uploaded.
    And I quit the browser