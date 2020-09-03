package newTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import TestBase.BaseClass;

public class LoginFailure extends BaseClass{

	public static void main(String[] args) {

		setUp("login");
		
		WebElement login = driver.findElement(By.id("username"));

		login.sendKeys("billykimber");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("1234567");

		WebElement submit = driver.findElement(By.xpath("//button[@class='radius']"));
		submit.click();
		
		WebElement invalidCredentials=driver.findElement(By.id("flash"));
		
		if(invalidCredentials.isDisplayed()) {
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}
		
		driver.quit();

	}
}