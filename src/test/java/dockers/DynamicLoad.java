package dockers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoad {
	    
		@Test
	    public void DynamicLoad() {
			
			String url = "http://localhost:7080/dynamic_loading/2";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			WebElement removeElement = driver.findElement(By.xpath("//div[@id='start']/button"));
			removeElement.click();
			
			WebElement deleteMessageElement = driver.findElement(By.id("finish"));
			String deleteMessage = deleteMessageElement.getText();
			String expectedMessage = "Hello World!";
			Assert.assertTrue(deleteMessage.equalsIgnoreCase(expectedMessage));
			driver.close();

		}

}
