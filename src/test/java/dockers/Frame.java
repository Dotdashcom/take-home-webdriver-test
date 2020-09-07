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

public class Frame {
	   
		@Test
	    public void IFrameBoldAlignCenter(){
			
			String url = "http://localhost:7080/iframe";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			Actions actions = new Actions(driver);
			WebElement fieldElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
			
			// composite action
			actions.moveToElement(fieldElement).click().keyDown(Keys.CONTROL).sendKeys("a")
			.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("Automation for test cases 1").build().perform();
			
			WebElement boldElement = driver.findElement(By.xpath("//i[@class='mce-ico mce-i-bold']"));
			WebElement alignCenter = driver.findElement(By.xpath("//i[@class='mce-ico mce-i-aligncenter']"));
			actions.moveToElement(fieldElement).click().keyDown(Keys.CONTROL).sendKeys("a").build().perform();
			boldElement.click();
			alignCenter.click();
			driver.close();

		}
		
		@Test
	    public void IFrameDelete(){
			
			String url = "http://localhost:7080/iframe";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			Actions actions = new Actions(driver);
			WebElement fieldElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
			
			// use menu for delete
			WebElement fileElement = driver.findElement(By.xpath("//button[@id='mceu_15-open']//i[@class='mce-caret']"));
			fileElement.click();
			WebElement newDoc = driver.findElement(By.id("mceu_31"));
			newDoc.click();
			
			fieldElement.sendKeys("AAutomation for test cases 2");
			driver.close();

		}

}
