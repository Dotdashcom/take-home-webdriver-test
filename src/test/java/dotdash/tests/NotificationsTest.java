package dotdash.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.pageobjects.NotificationPage;
import dotdash.pageobjects.UploadPage;
import dotdash.resources.base;

public class NotificationsTest extends base {

	public WebDriver driver;
	NotificationPage np;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("notificationsUrl"));
		
	}
	
	
	@Test
	public void validateFileUpload() throws IOException, InterruptedException {	
		
			 np= new NotificationPage(driver);
			 np.renderNotification("Action successful", "Action unsuccesful, please try again");
			 
			 
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}
	


}
