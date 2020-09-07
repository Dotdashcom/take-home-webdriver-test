package dockers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControl {
	    
		@Test
	    public void DynamicControl() {
			
			String url = "http://localhost:7080/dynamic_controls";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			
			WebElement removeElement = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
			removeElement.click();
			WebElement deleteMessageElement = driver.findElement(By.xpath("//p[@id='message']"));
			String deleteMessage = deleteMessageElement.getText();
			String expectedMessage = "It's gone!";
			Assert.assertTrue(deleteMessage.equalsIgnoreCase(expectedMessage));
			driver.close();
		}
		
		@Test
	    public void DynamicControlEnabled() {
			
			String url = "http://localhost:7080/dynamic_controls";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			
			WebElement enableElement = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
			enableElement.click();
			// message control
			WebElement deleteMessageElement = driver.findElement(By.xpath("//p[@id='message']"));
			String deleteMessage = deleteMessageElement.getText();
			String expectedMessage = "It's enabled!";
			Assert.assertTrue(deleteMessage.equalsIgnoreCase(expectedMessage));
			// control that text is enabled
			WebElement textElement = driver.findElement(By.xpath("//form[@id='input-example']//input")); 
			Assert.assertTrue(textElement.isEnabled());
			
			driver.close();
		}
		
}
