package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.Contextmenu;

public class ContextmenuTest extends BaseTest {

	public ContextmenuTest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("contextmenuurl"));
		Thread.sleep(1000);
		contextmenu = new Contextmenu();
		}
	
	    Contextmenu contextmenu;
	    

	    @Test
	    public void alerttest() {
	    	contextmenu.ContextmenuBox().accept();
	    	contextmenu.ContextmenuAssertion();
	    }

		@AfterMethod
		public void EndSignInTest() {
			quitbrowser();
	}




}
