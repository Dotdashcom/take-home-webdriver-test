package dockers;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Windows {
	   
		@Test
	    public void Window(){			
			
			String url = "http://localhost:7080/windows";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			WebElement fieldElement = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
			fieldElement.sendKeys(clickOnLinkTab);

			// switch the other tabs
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> iterator = windows.iterator();
			while(iterator.hasNext()){
				driver.switchTo().window(iterator.next());
			}
			driver.quit();
		}
		
	

}
