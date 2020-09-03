package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.BaseClass;

public class DynamicLoading extends BaseClass{
	public static void main(String[] args) {
		
		setUp("dynamic_loading/2");
		
		WebElement StartButton=driver.findElement(By.xpath("//button[text()='Start']"));
		StartButton.click();
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		
		WebElement text= driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		if(text.isDisplayed()) {
			System.out.println("Test case passed");
		}
		driver.quit();
		
	}

}
