import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicLoadingPage {
	
	@Test
	public static void DynamicLoadingPageTest() throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/dynamic_loading/2");
		
		driver.manage().window().maximize();
		
		WebElement button=driver.findElement(By.cssSelector("div[id='start'] button"));
		button.click();
		
		Thread.sleep(7000);
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[normalize-space()='Hello World!']"))));
		
		driver.quit();
		
	
		
		

	}

}
