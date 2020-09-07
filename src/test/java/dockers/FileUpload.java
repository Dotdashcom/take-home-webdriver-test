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

public class FileUpload {
	   
		@Test
	    public void Upload(){
			
			String url = "http://localhost:7080/upload";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

			WebElement chooseFile = driver.findElement(By.id("file-upload"));
			WebElement uploadButton = driver.findElement(By.id("file-submit"));

			chooseFile.sendKeys("C:\\Users\\mihru\\eclipse-workspace\\dockers\\uploadTest.txt");
			uploadButton.click();
			driver.close();

		}

}
