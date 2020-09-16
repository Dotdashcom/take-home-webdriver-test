package main.java;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BrowserUtilities {
	public static WebDriver driver;
	@BeforeClass
	public static WebDriver startanyBrowser(String browsername,String url)
	{
	//WebDriver driver=null;
	
	if(browsername.equalsIgnoreCase("chrome"))
	{
		
		final String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",dir +"\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\nazim\\workspace3\\take-home-webdriver-test\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
	}
	return driver;
	}
	@BeforeClass
	public static WebDriver startChromeBrowserwithCap(String browsername)
	{
		final String dir=System.getProperty("user.dir");
		File folder;
		folder=new File(UUID.randomUUID().toString());
		folder.mkdir();
		System.setProperty("webdriver.chrome.driver",dir +"\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		
		Map<String,Object> prefs=new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		 driver=new ChromeDriver(cap);
		 return driver;
	}
	
	public static void closebrowser()
	{
		
		driver.quit();
	}
	
	public static WebElement waitforElementToBeVisible1(WebDriver driver,WebElement element,int seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,seconds);
		WebElement elementcheck=wait.until(ExpectedConditions.visibilityOf(element));
		return elementcheck;
		
	}
	
	public static WebElement waitforElementToBeInVisible(WebDriver driver,WebElement element,int seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,seconds);
		WebElement hide=wait.until(ExpectedConditions.visibilityOf(element));
		return hide;
		
	}
//	public static Boolean waitforElementToBeInVisible(WebDriver driver,WebElement element,int seconds) throws Exception
//	{
//		Boolean hide = null;
//		try
//		{
//		WebDriverWait wait=new WebDriverWait(driver,seconds);
//		wait.until(ExpectedConditions.InvisibilityOfElementLocated(By.xpath("//form[@id=\\\"checkbox-example\\\"]/div/input[@id=\\\"checkbox\\")));
//		//return hide;
//		}
//		catch(Exception ea)
//		{
//			ea.printStackTrace();
//		}
//		catch (NoSuchElementException | TimeoutException e) {
//	        System.out.println("FullWidth element not found!");
//	        System.out.println(e);
//		}
//		
//		return hide;
//	}

}

