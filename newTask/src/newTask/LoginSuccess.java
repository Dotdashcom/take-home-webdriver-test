package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import TestBase.BaseClass;

public class LoginSuccess extends BaseClass{

	public static void main(String[] args) {
		
		setUp("login");
		
		WebElement login= driver.findElement(By.id("username"));
		
		login.sendKeys("tomsmith");
		
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		
		WebElement submit=driver.findElement(By.xpath("//button[@class='radius']")); 
		submit.click();
		
		WebElement success=driver.findElement(By.xpath("//h4[@class='subheader']"));
		
		if(success.isDisplayed()) {
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}
	
		driver.quit();
	}
}
