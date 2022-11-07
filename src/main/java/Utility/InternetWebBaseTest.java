package Utility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;


public class InternetWebBaseTest extends InternetBasePage {
	
	private String drivertype="chrome";


	@BeforeMethod
	public void setup() throws IOException {
		driver=getDriver(drivertype);
 		driver.manage().window().maximize();
       
	}

	@AfterMethod
	public void clear() {
		driver.quit();
	}

}
