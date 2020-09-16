//Program to verify login for valid & invalid credentials
package main.java;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import main.PageObjects.HandleElementsPage;




public class Taketest {
	final String dir=System.getProperty("user.dir");
	WebDriver testdriver=null;
	@Test
	public void testcase1()
	{
	
	try
	{
	testdriver=BrowserUtilities.startanyBrowser("chrome", "http://localhost:7080/login");
	testdriver.manage().window().maximize();
	
	LoginPagge login=PageFactory.initElements(testdriver,LoginPagge.class);
	login.logincredentials("tomsmith", "SuperSecretPassword!");

	
	BrowserUtilities.closebrowser();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	}
	
	@Test
	public void testcase2()
	{
	//Setup

	testdriver=BrowserUtilities.startanyBrowser("chrome", "http://localhost:7080/login");
	testdriver.manage().window().maximize();
	
	LoginPagge login=PageFactory.initElements(testdriver,LoginPagge.class);
	login.logincredentials("nazima", "Password!");
	

	BrowserUtilities.closebrowser();
		
}
	@Test
	public void testcase3()
	{
		testdriver=BrowserUtilities.startanyBrowser("chrome", "http://localhost:7080/checkboxes");
		testdriver.manage().window().maximize();
		HandleElementsPage handle=PageFactory.initElements(testdriver, HandleElementsPage.class);
	handle.Handleinit(testdriver);
	
	handle.handlingcheckbox();
	BrowserUtilities.closebrowser();
}
	@Test
public void testcase4()
	{
	testdriver=BrowserUtilities.startanyBrowser("chrome", "http://localhost:7080/context_menu");
	testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	testdriver.manage().window().maximize();
	HandleElementsPage handle=PageFactory.initElements(testdriver, HandleElementsPage.class);
	handle.Handleinit(testdriver);
	handle.handlingcontextmenu();
	BrowserUtilities.closebrowser();
}
	@Test
	public void testcase5() throws Exception
	{
	testdriver=BrowserUtilities.startanyBrowser("chrome","http://localhost:7080/drag_and_drop");
	testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	testdriver.manage().window().maximize();
	HandleElementsPage handle=PageFactory.initElements(testdriver, HandleElementsPage.class);
	handle.Handleinit(testdriver);
	handle.handlingdraganddrop();
	BrowserUtilities.closebrowser();
	}
	@Test
public void testcase6() throws Exception
	{
	testdriver=BrowserUtilities.startanyBrowser("chrome","http://localhost:7080/dropdown");
		testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	testdriver.manage().window().maximize();
	HandleElementsPage handle=PageFactory.initElements(testdriver, HandleElementsPage.class);
	handle.Handleinit(testdriver);
	handle.handledropdown();
	BrowserUtilities.closebrowser();
	}
	@Test
	public void testcase7() throws Exception
	{
	testdriver=BrowserUtilities.startanyBrowser("chrome","http://localhost:7080/dynamic_content");
	testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	testdriver.manage().window().maximize();
	HandleElementsPage handle=PageFactory.initElements(testdriver, HandleElementsPage.class);
	handle.Handleinit(testdriver);
	handle.handledynamiccontent();
	BrowserUtilities.closebrowser();
	}
	@Test
	public void testcase8() 
	{
	testdriver=BrowserUtilities.startanyBrowser("chrome","http://localhost:7080/dynamic_controls");
	testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testdriver.manage().window().maximize();
	HandleElementsPage handle=PageFactory.initElements(testdriver, HandleElementsPage.class);
	handle.Handleinit(testdriver);
	handle.handledynamiccontrols();
	BrowserUtilities.closebrowser();
	}
   @Test
	public void testcase9() 
	{
	testdriver=BrowserUtilities.startanyBrowser("chrome","http://localhost:7080/dynamic_loading/2");
	testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testdriver.manage().window().maximize();
		HandleElementsPage handle=PageFactory.initElements(testdriver, HandleElementsPage.class);
	handle.Handleinit(testdriver);
	handle.dynamicpageloading();
	BrowserUtilities.closebrowser();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testcase10() throws Exception 
	{
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
	
		testdriver=new ChromeDriver(cap);
		//testdriver=BrowserUtilities.startChromeBrowserwithCap("chrome");
		testdriver.get("http://localhost:7080/download");
		testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testdriver.manage().window().maximize();
		//testdriver.findElement(By.xpath("//body/div[2]/div/div/a")).click();
		testdriver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(2000);
		
			File lisFile[]=folder.listFiles();
				Assert.assertTrue(lisFile.length>0);

		
	for(File file:lisFile)
		{
			Assert.assertTrue(lisFile.length>0);
		}
	
	testdriver.quit();
	for(File file:folder.listFiles())
	{
		file.delete();
	}
	
folder.delete();
}	
	@Test
	public void testcase11()
	{
		//Robot class or AutoIT also used for fileUpload when there is no input field while handling for upload file
	 System.setProperty("webdriver.chrome.driver",dir +"\\chromedriver.exe");
	testdriver=new ChromeDriver();
	testdriver.get("http://localhost:7080/upload");
		testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testdriver.manage().window().maximize();
		testdriver.findElement(By.xpath("//form/input[@id=\"file-upload\"]")).sendKeys(dir+"\\uploadfile.txt");
		testdriver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();
		WebElement ele=testdriver.findElement(By.xpath("//div/h3[contains(text(),\"File Uploaded!\")]"));
		Assert.assertTrue(ele.isDisplayed());
		BrowserUtilities.closebrowser();	
	}
	@Test
	public void testcase12() 
	{
	testdriver=BrowserUtilities.startanyBrowser("chrome","http://localhost:7080/floating_menu");
	testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testdriver.manage().window().maximize();
		HandleElementsPage handle=PageFactory.initElements(testdriver, HandleElementsPage.class);
		handle.Handleinit(testdriver);
		WebElement endelement=testdriver.findElement(By.xpath("//div[@id=\"page-footer\"]/div/div/a"));
		handle.scrollhandle(endelement);
		handle.floatingmenuhandle();
		BrowserUtilities.closebrowser();
	}
	@Test
	public void testcase13() throws Exception 
	{
		testdriver=BrowserUtilities.startanyBrowser("chrome"," http://localhost:7080/iframe");
		testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testdriver.manage().window().maximize();
		HandleElementsPage handle=PageFactory.initElements(testdriver, HandleElementsPage.class);
		handle.Handleinit(testdriver);
		handle.handleiframe();
		BrowserUtilities.closebrowser();
	}
	@Test
	public void testcase14() throws Exception 
	{
		testdriver=BrowserUtilities.startanyBrowser("chrome"," http://localhost:7080/hovers");
		testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testdriver.manage().window().maximize();
		HandleElementsPage handle=PageFactory.initElements(testdriver, HandleElementsPage.class);
		handle.Handleinit(testdriver);
		handle.mouseover();
		BrowserUtilities.closebrowser();
	}
	@Test
	public void testcase15() throws Exception 
	{
		try {
			testdriver=BrowserUtilities.startanyBrowser("chrome","http://localhost:7080/javascript_alerts");
		testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testdriver.manage().window().maximize();
		WebElement JSbtn1 = testdriver.findElement(By.xpath("//button[contains(text(),\"Click for JS Alert\")]"));
		WebElement JSbtn2 = testdriver.findElement(By.xpath("//button[contains(text(),\"Click for JS Confirm\")]"));
		WebElement JSbtn3 = testdriver.findElement(By.xpath("//button[contains(text(),\"Click for JS Prompt\")]"));
		HandleElementsPage.handleJSalerts(testdriver,JSbtn1);
		UtilityScreenshot.captureScreenshot(testdriver,"alert1");
	Thread.sleep(500);
	HandleElementsPage.handleJSalerts(testdriver,JSbtn2);
		HandleElementsPage.handleJSalerts(testdriver,JSbtn3);
		
		}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		BrowserUtilities.closebrowser();
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testcase16() throws Exception
	{		
		testdriver=BrowserUtilities.startanyBrowser("chrome"," http://localhost:7080/javascript_error");
		testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testdriver.manage().window().maximize();
		Set<String> logTypes=testdriver.manage().logs().getAvailableLogTypes();
		for(String string:logTypes)
		{
			System.out.println(string);
		}
		LogEntries logEntries=testdriver.manage().logs().get(LogType.BROWSER);
		
		List<LogEntry> logs=logEntries.filter(Level.ALL);
		for(LogEntry logEntry:logs)
		{
			System.out.println(logEntry);
		}
		BrowserUtilities.closebrowser();
	}
	@Test
	public void testcase17() throws Exception
{
		
	testdriver=BrowserUtilities.startanyBrowser("chrome","http://localhost:7080/windows");
	testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testdriver.manage().window().maximize();
		String parent = testdriver.getWindowHandle();
		System.out.println("Parent Window"+parent);
		testdriver.findElement(By.xpath("//div[@class=\"example\"]/a[contains(text(),\"Click Here\")]")).click();
		Thread.sleep(1000);
		Set<String> et =testdriver.getWindowHandles();
	int count=et.size();
		System.out.println("Parent and child Windows count"+et);
		for(String child:et)
	{
			if(!parent.equalsIgnoreCase(child))
			{
				testdriver.switchTo().window(child);
				WebElement ele=testdriver.findElement(By.xpath("//body/div/h3[contains(text(),\"New Window\")]"));
				Assert.assertTrue(ele.isDisplayed());
			Thread.sleep(1000);
				testdriver.close();
			}
		}
		BrowserUtilities.closebrowser();
	}

	
	@Test
	public void testcase18() throws Exception
	{
		testdriver=BrowserUtilities.startanyBrowser("chrome","http://localhost:7080/notification_message_rendered");
	testdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	testdriver.manage().window().maximize();
	WebElement c=testdriver.findElement(By.xpath("//div[@class=\"example\"]/p/a[contains(text(),\"Click here\")]"));
		c.click();

	Wait<WebDriver> wait=new FluentWait<WebDriver>(testdriver)
				
			
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(StaleElementReferenceException.class);
		WebElement ele=testdriver.findElement(By.xpath("//div[@id=\"flash-messages\"]/div[contains(text(),\"Action\")]"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		c.click();
		wait.until(ExpectedConditions.visibilityOf(ele));
		c.click();
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		}
	
}


