@log
Feature: Test Interview


Scenario Outline: User able to signin with valid credentials
	Given  Navigate to "http://localhost:7080/login" site
		When give <username> and <Password>
		Then LogIn should be successfull 
		And Close to the window
	
Examples:
|username  |Password|
|tomsmith  |SuperSecretPassword!|

Scenario Outline: User able to signin with Invalid credentials

	Given  Navigate to "http://localhost:7080/login" site
	
	When give <username> and <Password>
	
	Then LogIn should be unsuccessful 
	
	And Close to the window

Examples:

|username  |Password|
|tom  |SecretPassword!| 


Scenario: Check and uncheck boxes

	Given  Navigate to "http://localhost:7080/checkboxes" site
	
	When checked the check box
	
	And Unchecked the check box
	
	Then Checked should be check
	
	And Unchecked should be uncheck
	
	And Close to the window
	
Scenario: ContextMenu
	
	Given  Navigate to "http://localhost:7080/context_menu" site	
	When Right-click in the box to see alert Box	
	Then Close to the window
	

Scenario: Drag and Drop 

	Given  Navigate to "http://localhost:7080/drag_and_drop" site
	
	When Perofrm Drag And Drop in a Webdriver test
	
	Then Close to the window

Scenario: Dropdown

	Given  Navigate to "http://localhost:7080/dropdown" site
	
	When Test dropdown using Webdriver.
	
	Then dropdown should be successfull
	
	And Close to the window
	
	
Scenario: Dynamic Content

	Given  Navigate to "http://localhost:7080/dynamic_content" site
	
	When Test content changes with page reload.
	
	Then Dynamic Content should be successfull
	
	And Close to the window

Scenario: Dynamic Controls

	Given  Navigate to "http://localhost:7080/dynamic_controls" site
	
	When Test Dynamic Controls using Explicit Waits.
	
	Then Dynamic Controls should be successfull
	
	And Close to the window
	
Scenario: Dynamic Load

Given  Navigate to "http://localhost:7080/dynamic_loading/2" site

	When Test Dynamic Loading using Explict Waits.
	
	Then Dynamic Loading should be successfull
	
	And Close to the window

Scenario: File Download
	Given  Navigate to "http://localhost:7080/download" site
	
	When Test File Download.
	
	Then File Download should be successfull
	
	And Close to the window



Scenario: File Upload

	Given  Navigate to "http://localhost:7080/upload" site
	
	When Test File Upload.
	
	Then File Upload should be successfull
	
	And Close to the window

Scenario: Iframe

	Given  Navigate to "http://localhost:7080/iframe" site
	
	When Test iframe.
	
	Then Test iframe should be successfull
	
	And Close to the window

Scenario: Mouse Hover

	Given  Navigate to "http://localhost:7080/hovers" site
	
	When Test Mouse Hover.
	
	Then Mouse Hover should be successfull
	
	And Close to the window

Scenario: JavaScript Alerts

	Given  Navigate to "http://localhost:7080/javascript_alerts" site
	
	When Test confirm JS Alert.
	
	Then JavaScript Alerts should be successfull
	
	And Close to the window

Scenario: JavaScript Error

	Given  Navigate to "http://localhost:7080/javascript_error" site
	
	When Test JS error.
	
	Then Test JS error should be successfull
	
	And Close to the window

Scenario: Open in New Tab

	Given  Navigate to "http://localhost:7080/windows" site
	
	When Test Link Opens in new tab.
	
	Then Open in New Tab should be successfull
	
	And Close to the window



Scenario: Notification Message

	Given Navigate to "http://localhost:7080/notification_message_rendered" site
	
	When Test notification Message.
	
	Then Notification Message should be successfull
	
	And Close to the window


