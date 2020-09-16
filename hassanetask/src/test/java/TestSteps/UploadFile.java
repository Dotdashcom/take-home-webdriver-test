package TestSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class UploadFile {

	
	WebDriver driver;

	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/upload");

	}

	@Test
	public void download() throws Exception {
 //work only whene type = file
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Owner\\Downloads\\some-file.txt");
		
		Thread.sleep(3000);
		driver.findElement(By.id("file-submit")).click();
		
		String actualtext = "File Uploaded!";
		String expectettext = driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
		Assert.assertEquals(actualtext, expectettext);
		
			}
	
 @AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
	}

	
	
}
