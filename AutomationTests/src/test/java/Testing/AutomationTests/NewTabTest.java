package Testing.AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.NewTabPage;
import resources.base;

public class NewTabTest extends base {
	public WebDriver driver;
	NewTabPage newTab;


	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("windowsUrl"));

	}


	@Test
	public void validateNewWindowText() throws IOException, InterruptedException {	
		newTab = new NewTabPage(driver);
			String newUrl=newTab.openAndSwitchToNewTab();
			Assert.assertEquals(newUrl, "http://localhost:7080/windows/new");
			String title=newTab.checkNewTabText();
			Assert.assertEquals(title, "New Window");
		}



	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}
}
