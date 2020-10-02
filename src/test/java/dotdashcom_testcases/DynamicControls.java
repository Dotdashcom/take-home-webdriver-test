package dotdashcom_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicControls {
	public static WebDriver driver;
	WebDriverWait wait;
	
	//method to start browser
	@BeforeMethod
	public void BrowserInvoking()
	{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();
		
		//receiving url to the browser
		driver.get("http://localhost:7080/dynamic_controls");
		
		//maximixing window
		driver.manage().window().maximize();
	}
	
	@Test
	public void enable_and_disable()
	{
		wait =new WebDriverWait(driver, 20);	
		
		
		
		WebElement enable_button  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-example\"]/button")));
		enable_button.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String textbox_removed_text =driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/p")).getText();
		System.out.println("Text available after removing checkbox : " +textbox_removed_text);
		
		
		WebElement disable_button  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button")));
		disable_button.click();

		String textbox_enabled_text =driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/p")).getText();
		System.out.println("Text available after removing checkbox : " +textbox_enabled_text);
		
		
	}

}
