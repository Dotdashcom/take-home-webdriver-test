package qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class FileUploadTest extends TestBase {

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test
    public void fileUploadTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/upload");
		
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:/Users/Sonal Patel/Downloads/some-file.txt");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]")).getText(), "File Uploaded!");
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}
