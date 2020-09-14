package TestSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class ChechboxesTest {
WebDriver driver;
	@BeforeMethod
	public void launchbrowser() throws Exception {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/checkboxes");
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}
	@Test
	public void checkbox_and_incheckbox() throws Exception {
		//checkbox test
		driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")).click();
		Thread.sleep(3000);
		
		//incheckbox test
		driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).click();
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
	}
}
