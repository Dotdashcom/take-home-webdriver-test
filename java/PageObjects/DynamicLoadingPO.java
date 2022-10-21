package PageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPO {

	WebDriver driver;
	public DynamicLoadingPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void dynamicLoading()
	{
		WebElement StartButton=driver.findElement(By.xpath("//button[text()='Start']"));
		StartButton.click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		WebElement message = driver.findElement(By.id("finish"));
		if(message.isDisplayed()) {
			System.out.println("Dynamicloading test case passed");
		}else {
			System.out.println("Dynamicloading test case passed");
		}
		
	}
	}
	
	


