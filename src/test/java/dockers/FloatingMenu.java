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

public class FloatingMenu {
	   
		@Test
	    public void FloatMenu(){
			
			String url = "http://localhost:7080/floating_menu";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

			WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
			WebElement news = driver.findElement(By.xpath("//a[contains(text(),'News')]"));
			WebElement contact = driver.findElement(By.xpath("//a[contains(text(),'Contact')]"));
			WebElement about = driver.findElement(By.xpath("//a[contains(text(),'About')]"));

			home.click();
			Assert.assertEquals(driver.getCurrentUrl().toString(), "http://localhost:7080/floating_menu#home");
			news.click();
			Assert.assertEquals(driver.getCurrentUrl().toString(), "http://localhost:7080/floating_menu#news");
			contact.click();
			Assert.assertEquals(driver.getCurrentUrl().toString(), "http://localhost:7080/floating_menu#contact");
			about.click();
			Assert.assertEquals(driver.getCurrentUrl().toString(), "http://localhost:7080/floating_menu#about");
			driver.close();

		}

}
