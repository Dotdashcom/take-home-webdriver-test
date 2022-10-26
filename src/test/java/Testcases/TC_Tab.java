package Testcases;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_Tab {
	@Test
	public void tabtest(){
		
		String URL ="http://localhost:7080/windows";
		 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 driver.get(URL);
		 
		 WebElement click1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		 click1.click();
		 
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "New Window";
		assertEquals(ActualTitle, ExpectedTitle, ActualTitle);
		System.out.println("AssertPass");
	}

}
