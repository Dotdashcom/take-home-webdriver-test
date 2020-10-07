package com.company.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class BrowseFactory {
	
	static WebDriver driver;
	@BeforeTest
	public static void setUp()
	{
		
		System.out.println("Browser is opening");
	}
	public static WebDriver StartBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver", "P:\\Software\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	
	@AfterTest
	public static void tearDown()
	{
		//driver.quit();//As per request Browser should not close
		
		System.out.println("Browser is closing");
	}
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	public static boolean verifyContentChange(WebElement content) {
		String firstText=content.getText();
		driver.navigate().refresh();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return firstText.equalsIgnoreCase(content.getText());
	}

}
