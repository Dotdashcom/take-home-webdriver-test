package stepDefinition;

import pageobjectmodel.pageObjectModel;
import common.Base;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition extends Base{
	
	pageObjectModel pom;
	
	String result;
	boolean b;
	
	
	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String url) throws Throwable {
		initializeChromeBrowser();	
		navigateToSite(url);
		
		pom = PageFactory.initElements(driver, pageObjectModel.class);
	    
	}

	@When("^give (.+) and (.+)$")
	public void give_tomsmith_and_SuperSecretPassword(String username, String password) throws Throwable {
		result = pom.getLogin(username, password);	   
		if(result.equals("You logged into a secure area!\n×")) {
			b = true;
		}
		else {
			b=false;
		}
	}

	@Then("^LogIn should be successfull$")
	public void login_should_be_successfull() throws Throwable {		
	    
		Assert.assertTrue(b);
	}
	
	

	@Then("^Close to the window$")
	public void close_to_the_window() throws Throwable {
	    
		closeBrowser();
	}
	

	@Then("^LogIn should be unsuccessful$")
	public void login_should_be_unsuccessful() throws Throwable {
	    
		Assert.assertFalse(b);
	}

	
	
	@When("^checked the check box$")
	public void checked_the_check_box() throws Throwable {
	    
		b = pom.getIsCheck();
	}

	@When("^Unchecked the check box$")
	public void unchecked_the_check_box() throws Throwable {
	    
	    
	}

	@Then("^Checked should be check$")
	public void checked_should_be_check() throws Throwable {
	    System.out.print(b);
		//Assert.assertTrue(b);
	}

	@Then("^Unchecked should be uncheck$")
	public void unchecked_should_be_uncheck() throws Throwable {
	    
		System.out.print(b);
		//Assert.assertTrue(b);
	}
	
	@When("^Right-click in the box to see alert Box$")
	public void right_click_in_the_box_to_see_alert_Box() throws Throwable {
		 pom.getcontextmenuk();
	}
	
	
	@When("^Perofrm Drag And Drop in a Webdriver test$")
	public void perofrm_Drag_And_Drop_in_a_Webdriver_test() throws Throwable {
	    pom.dragAndDrop();	    
	}

	@Then("^should be success$")
	public void should_be_success() throws Throwable {
	    
	    
	}
	
	@When("^Test dropdown using Webdriver\\.$")
	public void test_dropdown_using_Webdriver() throws Throwable {
	    
	    pom.selectElement();
	}

	@Then("^dropdown should be successfull$")
	public void dropdown_should_be_successfull() throws Throwable {
	    
	    
	}
	
	
	
	@When("^Test content changes with page reload\\.$")
	public void test_content_changes_with_page_reload() throws Throwable {
	    
	    pom.DynamicContent();
	}

	@Then("^Dynamic Content should be successfull$")
	public void dynamic_Content_should_be_successfull() throws Throwable {
	    
	    
	}

	@When("^Test Dynamic Controls using Explicit Waits\\.$")
	public void test_Dynamic_Controls_using_Explicit_Waits() throws Throwable {
	     pom.DynamicControl();
	    
	}

	@Then("^Dynamic Controls should be successfull$")
	public void dynamic_Controls_should_be_successfull() throws Throwable {
	    
	    
	}
	
	@When("^Test Dynamic Loading using Explict Waits\\.$")
	public void test_Dynamic_Loading_using_Explict_Waits() throws Throwable {
	    
	    pom.DynamicLoad();
	}

	@Then("^Dynamic Loading should be successfull$")
	public void dynamic_Loading_should_be_successfull() throws Throwable {
	    
	    
	}
	
	
	@When("^Test File Download\\.$")
	public void test_File_Download() throws Throwable {
	    
		pom.Download();
	    
	}

	@Then("^File Download should be successfull$")
	public void file_Download_should_be_successfull() throws Throwable {
	    
	    
	}

	@When("^Test File Upload\\.$")
	public void test_File_Upload() throws Throwable {
	    
	    pom.Upload();
	}

	@Then("^File Upload should be successfull$")
	public void file_Upload_should_be_successfull() throws Throwable {
	    
	    
	}
	
	
	
	@When("^Test iframe\\.$")
	public void test_iframe() throws Throwable {
	    
	    pom.IFrame();
	}

	@Then("^Test iframe should be successfull$")
	public void test_iframe_should_be_successfull() throws Throwable {
	    
	    
	}

	@When("^Test Mouse Hover\\.$")
	public void test_Mouse_Hover() throws Throwable {
	    
	    pom.MouseHover();
	}

	@Then("^Mouse Hover should be successfull$")
	public void mouse_Hover_should_be_successfull() throws Throwable {
	    
	    
	}

	@When("^Test confirm JS Alert\\.$")
	public void test_confirm_JS_Alert() throws Throwable {
	    
	    pom.JavaScriptAlerts();
	}

	@Then("^JavaScript Alerts should be successfull$")
	public void javascript_Alerts_should_be_successfull() throws Throwable {
	    
	    
	}

	@When("^Test JS error\\.$")
	public void test_JS_error() throws Throwable {
	    
	    pom.JavaScriptError();
	}

	@Then("^Test JS error should be successfull$")
	public void test_JS_error_should_be_successfull() throws Throwable {
	    
	    
	}

	@When("^Test Link Opens in new tab\\.$")
	public void test_Link_Opens_in_new_tab() throws Throwable {
	    
	    pom.OpeninNewTab();
	}

	@Then("^Open in New Tab should be successfull$")
	public void open_in_New_Tab_should_be_successfull() throws Throwable {
	    
	    
	}

	@When("^Test notification Message\\.$")
	public void test_notification_Message() throws Throwable {
	    
	    pom.NotificationMessage();
	}

	@Then("^Notification Message should be successfull$")
	public void notification_Message_should_be_successfull() throws Throwable {
	    
	    
	}	

}
