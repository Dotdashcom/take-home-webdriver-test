package Testcases;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC_dynamiccontrol {
	@SuppressWarnings("deprecation")
	@Test
	
	public void test() throws InterruptedException {
		
		String URL ="http://localhost:7080/dynamic_controls";
		 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 driver.get(URL);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 
		 WebElement element = driver.findElement(By.xpath("//*[@id=\"checkbox\"]/input"));
		 element.click();
		 
		 WebElement remove = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		 remove.click();
		 driver.manage().timeouts().getImplicitWaitTimeout();
		 
		 WebElement el = driver.findElement(By.id("message"));
		 Assert.assertEquals(true,el.isDisplayed());
		 
		 WebElement add = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		 add.click();
		 driver.manage().timeouts().getImplicitWaitTimeout();
		 WebElement r = driver.findElement(By.xpath("//*[@id=\"checkbox\"]"));
		 Assert.assertEquals(true,r.findElements(By.xpath("//*[@id=\"checkbox\"]")));
		 
		 
		 WebElement enable = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		 enable.click();
		 Assert.assertEquals("It's enabled", enable, enable);
		 driver.manage().timeouts().getImplicitWaitTimeout();
		 
		 WebElement textbox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
		 textbox.sendKeys("text");
		 WebElement n= driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		 n.click();
		 driver.manage().timeouts().getImplicitWaitTimeout();
		 
			driver.close();		 
				
	}
	
 
	 
 }

