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

public class FileDownload {
	
		@Test
	    public void Download() {
			
			String url = "http://localhost:7080/download";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

			WebElement downloadElement = driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]"));
			downloadElement.click();
			driver.close();

		}

}
