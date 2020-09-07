package dockers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseHover {
	   
		@Test
	    public void IFrameBoldAlignCenter() throws InterruptedException{
			
			String url = "http://localhost:7080/hovers";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			Actions actions = new Actions(driver);
			WebElement hover1 = driver.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
			WebElement hover2 = driver.findElement(By.xpath("//div[@class='example']//div[2]//img[1]"));
			WebElement hover3 = driver.findElement(By.xpath("//div[@class='example']//div[3]//img[1]"));
			
			Thread.sleep(2000);
			actions.moveToElement(hover1).build().perform();
			
			Thread.sleep(2000);
			actions.moveToElement(hover2).build().perform();	
			
			Thread.sleep(2000);
			actions.moveToElement(hover3).build().perform();
			
			driver.close();

		}
		


}
