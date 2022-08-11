package Test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.MainClass;

public class FileDownloadTest extends MainClass{

	@Before
    public void Setup()
	{
		startBrowser();
	}
	
	@Test
	public void verify_DownlaodFile()
	{
		driver.get("http://localhost:7080/download");
		WebElement FileDownlaodLink = driver.findElement(By.linkText("some-file.txt"));
		//delete file before download if exists
        FileDownlaodLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(filepresent());
		assertTrue(true);
	}
	
	
	public ExpectedCondition<Boolean> filepresent() {
	    return new ExpectedCondition<Boolean>() {
	        @Override
	        public Boolean apply(WebDriver driver) {
	            File f = new File(System.getProperty("user.home")+"/Downloads","some-file.txt"); 
	            return f.exists();
	        }
	        
	        @Override
	        public String toString() {
	          return String.format("file to be present within the time specified");
	        }
	    };
	}
	@After 
    public void tearDown() 
    {
    	closeBrowser();
    }

}
