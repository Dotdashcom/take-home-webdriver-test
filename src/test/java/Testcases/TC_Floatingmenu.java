package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TC_Floatingmenu {
	@Test
	public void floatingmenutest() {
		
		String URL ="http://localhost:7080/dynamic_controls";
		 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 driver.get(URL);
		 
		 
		 JavascriptExecutor js 	= (JavascriptExecutor)driver;
		 js.executeScript("window.scrolBy(0,350)", "");
		 
		 WebElement menu = driver.findElement(By.xpath("//*[@id=\"menu\"]"));
		assert menu.isDisplayed();
		 
		 driver.close();
		 
		 
	}

}
