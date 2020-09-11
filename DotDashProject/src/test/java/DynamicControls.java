import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicControls {
	@Test	
	public void Controls() {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:7080/dynamic_controls");
		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//This will check the checkbox
		driver.findElement(By.xpath("//div[@id='checkbox']//input")).click();
		
		//I am using explicit wait here to handle a specific webElement named "remove"
		//webdriver will wait for 30 seconds before throwing a TimeoutException. 
		//If it finds the element before 30 seconds, then it will return immediately
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Remove')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
	
		//I am using explicit wait here to handle a specific webElement named "Enable"
		//webdriver will wait for 30 seconds before throwing a TimeoutException. 
		//If it finds the element before 30 seconds, then it will return immediately
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enable')]")));
	
		
		driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
		
	}
		
		
		
	}

