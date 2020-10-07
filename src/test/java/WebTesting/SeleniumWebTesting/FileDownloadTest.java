package WebTesting.SeleniumWebTesting;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class FileDownloadTest  extends base {

	@Test()
	public void FileDownloadTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/download");
		String expectedHomePageURL = "The Internet";
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		//wait variable created
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		//webelement to download file
		WebElement downloadFile = driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]"));
		//To run this test change location according to your preference
		String expectedPath = "/Users/satinderpalsingh/Downloads/";
		String expectedFileName = "some-file.txt";
		//Path for downloading file and creating a file object
		File file = new File(expectedPath + expectedFileName);
		//checking if the file already exists in the location and deleting it
		if (file.exists())
		    file.delete();
		
		// downloading file here.
		downloadFile.click();
		Thread.sleep(2000);
		//Asserting if the file is available in the given location
		Assert.assertTrue(file.exists());
		
		//Not deleting the file as this file will be used for uploading in upload test
		
	}
	
}