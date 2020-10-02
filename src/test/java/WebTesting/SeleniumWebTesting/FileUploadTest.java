package WebTesting.SeleniumWebTesting;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class FileUploadTest  extends base {
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
	}
	
	@Test()
	public void FileUploadTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/upload");
		String expectedHomePageURL = "The Internet";;
		//checking if driver landed on expected page
		Assert.assertEquals(driver.getTitle(), expectedHomePageURL);
		WebElement chooseFileButton , uploadButton , confirmationText;
		
		chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
		uploadButton = driver.findElement(By.cssSelector("#file-submit"));
		//defining path . please change path according to your system
		String expectedPath = "/Users/satinderpalsingh/Downloads/";
		String expectedFileName = "some-file.txt";
		//Path for uploading file and creating a file object
		File file = new File(expectedPath + expectedFileName);
		//sending path for selection of file
		chooseFileButton.sendKeys(expectedPath + expectedFileName);
		// clicking upload button
	     uploadButton.click();
	     confirmationText = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]"));
	     //checking if the file is uploaded
	     Assert.assertTrue(confirmationText.isDisplayed());
		
	}
	
	
	@AfterTest
	public void teardown()
	{
		//closing and the quiting the driver
		//driver.close();	
		//driver.quit();
	}
}
