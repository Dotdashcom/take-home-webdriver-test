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

public class JsAlert {
	   
		@Test
	    public void JsAlert() throws InterruptedException{			
			String url = "http://localhost:7080/javascript_alerts";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
			jsAlert.click();
			Thread.sleep(2000);
			// Alert
			driver.switchTo().alert().accept();
			driver.close();

		}
		
		@Test
	    public void JsConfirm() throws InterruptedException{			
			
			String url = "http://localhost:7080/javascript_alerts";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
			jsAlert.click();
			Thread.sleep(2000);
			// Alert dismiss
			driver.switchTo().alert().dismiss();
			driver.close();

		}
		
		@Test
	    public void JsPrompt() throws InterruptedException{			
			
			String url = "http://localhost:7080/javascript_alerts";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
			jsAlert.click();
			Thread.sleep(2000);
			// Alert
			driver.switchTo().alert().sendKeys("This is an alert");
			driver.switchTo().alert().accept();
			driver.close();

		}

}
