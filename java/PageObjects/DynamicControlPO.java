package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlPO {

	WebDriver driver;
	public DynamicControlPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void dynamicControls()
	{
		WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkbox.click();
		
		WebElement remove=driver.findElement(By.xpath("//button[text()='Remove']"));
		remove.click();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		
		WebElement message1=driver.findElement(By.xpath("//p[@id='message']"));
		if(message1.isDisplayed()) {
			System.out.println("Test case 1 passed");
		}else {
			System.out.println("Test case 1 failed");
		}
		
		WebElement enableButton= driver.findElement(By.xpath("//button[text()='Enable']"));
		enableButton.click();
		WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		
		WebElement message2=driver.findElement(By.xpath("//p[@id='message']"));
		
		if(message2.isDisplayed()) {
			System.out.println("Test case 2 passed");
		}else {
			System.out.println("Test case 2 failed");			
		}	
	}

	
	}
	


