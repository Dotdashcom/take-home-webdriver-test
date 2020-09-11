import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicLoadings {
	
	@Test
	public void Loading() {

		
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:7080/dynamic_loading/2");
		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
		//I am using explicit wait here to handle a specific webElement named "remove"
		//webdriver will wait for 30 seconds before throwing a TimeoutException. 
		//If it finds the element before 30 seconds, then it will return immediately
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Start')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		
		//this will print the message after you succesfully click "start" 
		System.out.println(driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText());
	
		
		
   }
}
