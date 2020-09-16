Feature: Dot dash test cases

Scenario: Sign in with valid credentials
	    
    Given  go to the given url "http://localhost:7080/login"
    When   enter username and Password
    Then   successfull Log in
	And    Close to the current driver/window
	

Scenario: User able to signin with Invalid credentials

	Given  got to given url "http://localhost:7080/login" 
	When   enter username and Password
	Then   Log in successful 
	

Scenario: Checkboxes

	Given  go to given site "http://localhost:7080/checkboxes" 
	When   click the check box to make it checked
	Then   Checkbox should be checked succesfully

	
	
Scenario: ContextMenu
	
	Given  Navigate to "http://localhost:7080/context_menu" site	
	When   Right-click in the box to see alert Box	
	Then   Close to the window
	


Scenario: Drag&Drop 

	Given go to url "http://localhost:7080/drag_and_drop"
	When  drag an elemnet to drop on another element
	Then  it should be succefully performed drag and drop



Scenario: Dropdown

	Given  go to url "http://localhost:7080/dropdown" 
	When   Test dropdown using Webdriver.
	Then   dropdown should be successfull
	
	
Scenario: Dynamic Content

	Given  go to given site "http://localhost:7080/dynamic_content"
	When   Each time refresh the page, content changes
	Then   succesfully performed the operation

	
Scenario: Dynamic Loading

    Given  go to "http://localhost:7080/dynamic_loading/2"
	When   using explicit wait to load the dynamic element
	Then   loading successfull
	
	
Scenario: Dynamic Controls

	Given go to "http://localhost:7080/dynamic_controls"
	When  Using Explicit Waits on each element
	Then  element should be load succesfully
	


Scenario: File Uploading
	Given go to "http://localhost:7080/upload" 
	When  Upload a file
	Then  File Uploaded successfully
	



Scenario: File Download
	Given  go to "http://localhost:7080/download" site
	When   download a file
	Then   File fownloaded successfully

Scenario: Iframe

	Given  go to "http://localhost:7080/iframe" site
	When   go to child frame from parent fram
	Then   should be in iframe successfully


Scenario: Mouse Hover
	Given  go to "http://localhost:7080/hovers" site
	When   Hover over mouse on three of the user prfile.
	And    click view profile
	Then   mouse Hover should be performed successfully


Scenario: JavaScript Alerts
	Given  go to "http://localhost:7080/javascript_alerts"
	When   click all three of of the JS ALerts .
	Then   alert handled successfully


Scenario: JavaScript Errors
	Given  go to "http://localhost:7080/javascript_error" 
	When   check the page for js error.
	Then   JS error should be tested successfully


Scenario: Open New Tab

	Given  url "http://localhost:7080/windows" 
	When   click the link to check if a new tab opnd
	Then   New Tab opened successfully
	



Scenario: Notification Messages

	Given go to "http://localhost:7080/notification_message_rendered" 
	When  click on  linkTxt Click here.
	Then  get a notification message successfully.

	
	