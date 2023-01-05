package java.Pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FileDownloadPage {
	
	WebDriver driver;
	
	public FileDownloadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//div//a[@href='download/some-file.txt']")
	WebElement file;
	

	
	public boolean validateDownloadingFile() throws InterruptedException
	{
		file.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		final int SLEEP_TIME_MILLIS = 1000;
		String filePath = "C:\\Users\\Home\\Downloads\\some-file.txt";
		File file = new File(filePath);
	    final int timeout = 60* SLEEP_TIME_MILLIS;
	    int timeElapsed = 0;
		
	    while (timeElapsed<timeout){
	        if (file.exists()) {
	        	
	        	Assert.assertTrue(true);
	            
	        	System.out.println("some-file.txt is present");
	            return true;
	        } else {
	        	
	        	Assert.assertFalse(false);
	            
	        	timeElapsed +=SLEEP_TIME_MILLIS;
	            Thread.sleep(SLEEP_TIME_MILLIS);
	        }
		
		
	    }
	    return false;
		
		
	}
	
	
	
}
