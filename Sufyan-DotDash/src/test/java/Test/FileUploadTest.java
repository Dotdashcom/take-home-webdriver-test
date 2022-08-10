package Test;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Util.BrowserFactory;

public class FileUploadTest extends BrowserFactory{

	@Before
    public void Setup()
	{
		startBrowser();
	}
	
	@Test
	public void verify_UploadFile()
	{   
		//upload some-file.txt
		driver.get("http://localhost:7080/upload");
		//Choose file
		WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
		chooseFileButton.sendKeys(System.getProperty("user.home")+"\\Downloads\\some-file.txt");
		// Upload file
		WebElement uploadButton = driver.findElement(By.id("file-submit"));
		uploadButton.click();
		
		//Verify
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploaded-files")));
		assertTrue(true);
	}
	
	@After 
    public void tearDown() 
    {
    	closeBrowser();
    }


}
