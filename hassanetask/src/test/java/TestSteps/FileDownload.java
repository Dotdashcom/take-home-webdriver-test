package TestSteps;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.FileAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import utils.BrowserFactory;

public class FileDownload {
	WebDriver driver;

	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/download");

	}

	@Test
	public void download() throws Exception {

		WebElement element = driver.findElement(By.linkText("some-file.txt"));
		element.click();
		Thread.sleep(3000);
		File filelocation = new File("C:\\Users\\Owner\\Downloads");
		File[] totalfiles = filelocation.listFiles();
		for(File file:totalfiles) {
			if (file.getName().contains("some-file.tx")) {

				Assert.assertTrue(true); 
			}
			
		}
		
			}
	
 @AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
	}

}
