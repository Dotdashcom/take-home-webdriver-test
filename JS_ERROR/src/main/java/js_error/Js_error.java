package js_error;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Js_error {

	static String url = "http://localhost:7080/javascript_error";
	static  WebDriver driver;
    @BeforeTest
	public static void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
    @Test
    public void js_erros(){
    	LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		 List<LogEntry>lgEntries=logEntries.getAll();
		 for(LogEntry logEntry:lgEntries) {
			 System.out.println(logEntry);
		 }
		 
		 Assert.assertEquals(true, driver.getPageSource().contains("xyz"));
		 
    	
    }
    @AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	

}
