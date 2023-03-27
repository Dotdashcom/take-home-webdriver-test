# DotDash_QA_Automation 

## DotDash QA Automation is a Test Automation framework having test coverage for below scenarios
    Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
    Login Failure: http://localhost:7080/login Login fail invalid creadentials
    CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
    ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'. Test JavaScript alert text on Right-Click.
    Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.
    Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
    Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.
    Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
    Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.
    File Download: http://localhost:7080/download Test File Download.
    File Upload: http://localhost:7080/upload Test File Upload.
    Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
    Iframe: http://localhost:7080/iframe Test iframe.
    Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
    JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
    JavaScript Error: http://localhost:7080/javascript_error Test JS error.
    Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
    Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.


## Pre-requisite

1. Eclipse/Intellij IDE with GIT and TestNG plugin
2. Maven 3.8.4 (with environment path setup)
3. Web Browser Chrome/Firefox/Edge (any one would work)
4. Git setup locally
5. Docker image should be up and running on port 7080(in case of any other port, kindly update TestDefault.properties)
## Cloning Git Project

##### Command prompt (option 1)
	1. git clone https://github.com/seble2000/take-home-webdriver-test.git
	
##### Eclipse (option 2)
	1. Copy the GitHub URL https://github.com/seble2000/take-home-webdriver-test.git
	2. Open Eclipse and choose Import –> Projects from Git (with smart import)
	3. Choose the Clone URI option in the Git import wizard and click Next
	4. Confirm the URI, Host and Repository path parameters and click Next
	5. Choose the Git branches to clone from the remote repository and click Next
	6. Confirm the Directory into which the repository will be cloned and click Next
	7. Choose the Maven project to import into Eclipse from GitHub and click Finish

## Execution of Test Suite
##### Command prompt (option 1)
	1. Navigate to project root directory in command prompt
	2. Type "mvn clean test" and press enter
	After execution summary will look like below
	
	
##### Eclipse (option 2)
	1. Open testng.xml file located at src/resource/testng_suites
	2. Right Click and execute as TestNg Suite

	
## Folder Structure
	1. src>>main>>java>>com>>dotDash
		a. base :- this has 3 java files BaseTest,Contants & WebDriverContext which is having codes for Driver handling.
		b. page & page>>common :- POM based structure for each page.
		c. utils :- has utility library for Excel,Logger,Report and TestProperties.
		d. utils>>listeners :- has Logger and Reporter listeners
		e. utils>>reports :- has code of Extent Reports
	2. src>>resource
		a. testng_suites :- TestNG.xml suite files
		b. extent-config.xml :- Extent Report configuration
		c. log4j.xml :- Log4J configuration
		d. TestDefault.properties :- has key value pair for configuring browser,url and login credentials
	3. src>>test>>java>>com>>dotDash.test :- Consists of all test scripts , any test case addition, updation,deletion can be done here.
				
		
#### In case of any query/issue reachout sgebe1726@gmail.com
								

				
