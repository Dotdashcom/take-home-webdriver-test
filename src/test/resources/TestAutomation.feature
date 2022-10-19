Feature: Test Automation Scenarios

@automation
Scenario Outline: Verify login success
	Given Application is opened using "<url>" and on Home Page
	When User login using "<username>" and "<password>"
	Then verify login is successful
	Examples:
		|url							|username	|password				|
		|http://localhost:7080/login	|tomsmith	|SuperSecretPassword!	|

@automation
Scenario Outline: Verify invalid login
	Given Application is opened using "<url>" and on Home Page
	When User login using "<username>" and "<password>"
	Then verify login is unsuccessful
	Examples:
		|url							|username	|password				|
		|http://localhost:7080/login	|tomsmith	|SuperSecretPassword	|
		
@automation
Scenario Outline: Verify checkboxes
	Given Application is opened using "<url>" and on Home Page
	Then verify checkboxes
	Examples:
		|url								|
		|http://localhost:7080/checkboxes	|	

@automation
Scenario Outline: Verify contextmenu
	Given Application is opened using "<url>" and on Home Page
	Then verify context menu
	Examples:
		|url								|
		|http://localhost:7080/context_menu	|	
			
@automation
Scenario Outline: Verify drag and drop
	Given Application is opened using "<url>" and on Home Page
	Then verify drag and drop
	Examples:
		|url									|
		|http://localhost:7080/drag_and_drop	|	

@automation
Scenario Outline: Verify dynamic content
	Given Application is opened using "<url>" and on Home Page
	Then verify dynamic content
	Examples:
		|url									|
		|http://localhost:7080/dynamic_content	|

@automation
Scenario Outline: Verify dynamic controls
	Given Application is opened using "<url>" and on Home Page
	Then verify dynamic controls
	Examples:
		|url									|
		|http://localhost:7080/dynamic_controls	|

@automation
Scenario Outline: Verify dynamic loading
	Given Application is opened using "<url>" and on Home Page
	Then verify dynamic loading
	Examples:
		|url										|
		|http://localhost:7080/dynamic_loading/2 	|		

@automation
Scenario Outline: Verify file download
	Given Application is opened using "<url>" and on Home Page
	Then verify file download
	Examples:
		|url								|
		|http://localhost:7080/download 	|		
		
@automation
Scenario Outline: Verify file upload
	Given Application is opened using "<url>" and on Home Page
	Then verify file upload
	Examples:
		|url							|
		|http://localhost:7080/upload 	|
		
@automation
Scenario Outline: Verify floating menu
	Given Application is opened using "<url>" and on Home Page
	Then verify floating menu
	Examples:
		|url									|
		|http://localhost:7080/floating_menu 	|				

@automation
Scenario Outline: Verify frames
	Given Application is opened using "<url>" and on Home Page
	Then verify frames
	Examples:
		|url							|
		|http://localhost:7080/iframe 	|

@automation
Scenario Outline: Verify Mouse Hover
	Given Application is opened using "<url>" and on Home Page
	Then verify mouse hover
	Examples:
		|url							|
		|http://localhost:7080/hovers 	|
		
@automation
Scenario Outline: Verify Javascript alerts
	Given Application is opened using "<url>" and on Home Page
	Then verify javascript alerts
	Examples:
		|url										|
		|http://localhost:7080/javascript_alerts 	|
		
@automation
Scenario Outline: Verify Javascript error
	Given Application is opened using "<url>" and on Home Page
	Then verify javascript error
	Examples:
		|url									|
		|http://localhost:7080/javascript_error	|

@automation
Scenario Outline: Verify new window tab
	Given Application is opened using "<url>" and on Home Page
	Then verify new window
	Examples:
		|url							|
		|http://localhost:7080/windows	|				
		
@automation
Scenario Outline: Verify notifications
	Given Application is opened using "<url>" and on Home Page
	Then verify notifications
	Examples:
		|url													|
		|http://localhost:7080/notification_message_rendered	|
				
		