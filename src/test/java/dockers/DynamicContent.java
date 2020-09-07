package dockers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContent {
    
	@Test
    public void DynamicContentRemove() {
		
		String url = "http://localhost:7080/dynamic_controls";
		LoginWebDriver loginWebDriver = new LoginWebDriver();
		WebDriver driver = loginWebDriver.Login(url);
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		WebElement removeElement = driver.findElement(By.xpath("//form[@id='checkbox-example']/button"));
		removeElement.click();
		WebElement deleteMessageElement = driver.findElement(By.xpath("//p[@id='message']"));
		String deleteMessage = deleteMessageElement.getText();
		String expectedMessage = "It's gone!";
		Assert.assertTrue(deleteMessage.equalsIgnoreCase(expectedMessage));
		driver.close();
	}
	
	@Test
    public void DynamicContentEnabled() {
		
		String url = "http://localhost:7080/dynamic_controls";
		LoginWebDriver loginWebDriver = new LoginWebDriver();
		WebDriver driver = loginWebDriver.Login(url);
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement removeElement = driver.findElement(By.xpath("//form[@id='input-example']/button"));
		removeElement.click();
        WebElement deleteMessageElement = driver.findElement(By.xpath("//p[@id='message']"));
		String deleteMessage = deleteMessageElement.getText();
		String expectedMessage = "It's enabled!";
		Assert.assertTrue(deleteMessage.equalsIgnoreCase(expectedMessage));
		
		WebElement textElement = driver.findElement(By.xpath("//form[@id='input-example']//input"));
		textElement.sendKeys("dockers");
		driver.close();

	}
}
