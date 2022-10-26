package Testcases;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_Mousehover {
	@Test
	public void mousehovertest() {
		
		
		String URL ="http://localhost:7080/hovers";
		 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 driver.get(URL);
		 
		 
		 Actions actions = new Actions(driver);
		 WebElement i = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
		 actions.moveToElement(i).perform();
		 Assert.assertEquals(true,i.isDisplayed());
		 
		 WebElement r = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
		 actions.moveToElement(r).perform();
		 Assert.assertEquals(true,r.isDisplayed());
		 
		 WebElement j = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
		 actions.moveToElement(j).perform();
		 Assert.assertEquals(true,j.isDisplayed());
		 
		 driver.close();
		 
		 
	}

}
