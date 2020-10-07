package dotdashcom_testcases;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TC10_FileDownload extends BaseTest{
	
	WebDriver driver;
	File folder;
	
	//browser setup and starting
	@BeforeMethod
	public void setup()
	{
		//UUID file created
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		ChromeOptions options = new ChromeOptions();
		
		//key values are provided by chrome options by default
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popus",0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);
		
		
		

        
        
     
		
		
}
	@Test
	public void download() throws InterruptedException
	{
	
		driver.get("http://localhost:7080/download");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(2000);
		
		//test asserts is file is downladed or not
		File list_of_files[] = folder.listFiles();
		Assert.assertTrue(list_of_files.length>0);
		for(File file : list_of_files)
		{
			
			Assert.assertTrue(list_of_files.length>0);
		}
	}
	
	
	@AfterMethod
	public void teardown()
	{
		//browser closed
		driver.quit();
		
		//file deleted after browser is closed
		for(File file : folder.listFiles())
		{
			file.delete();
		}
		folder.delete();
	}

}
