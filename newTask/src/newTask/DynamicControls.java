package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.BaseClass;

public class DynamicControls extends BaseClass{
	
	public static void main(String[] args) {
		
		setUp("dynamic_controls");
		
		WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkbox.click();
		
		WebElement remove=driver.findElement(By.xpath("//button[text()='Remove']"));
		remove.click();
		
		WebDriverWait wait= new WebDriverWait(driver,50);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		
		WebElement message1=driver.findElement(By.xpath("//p[@id='message']"));
		if(message1.isDisplayed()) {
			System.out.println("Test case 1 passed");
		}else {
			System.out.println("Test case 1 failed");
		}
		
		WebElement enableButton= driver.findElement(By.xpath("//button[text()='Enable']"));
		enableButton.click();
		WebDriverWait wait2= new WebDriverWait(driver,30);
		
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		
		WebElement message2=driver.findElement(By.xpath("//p[@id='message']"));
		
		if(message2.isDisplayed()) {
			System.out.println("Test case 2 passed");
		}else {
			System.out.println("Test case 2 failed");			
		}

		driver.quit();
		
	}
}
