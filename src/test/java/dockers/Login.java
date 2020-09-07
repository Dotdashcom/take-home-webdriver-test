package dockers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {

	@Test
    public void LoginSuccess() {
		
		String url = "http://localhost:7080/login";
		LoginWebDriver loginWebDriver = new LoginWebDriver();
		WebDriver driver = loginWebDriver.Login(url);
		
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password =  driver.findElement(By.id("password"));
		WebElement loginButton =  driver.findElement(By.xpath("//button[@class='radius']"));
		
		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		loginButton.click();
	    
	    String actualResult = driver.findElement(By.xpath("//h4[@class='subheader']")).getText();
	    String expectedResult = "Welcome to the Secure Area. When you are done click logout below.";
	    Assert.assertEquals(actualResult, expectedResult);
	    driver.close();

	}
	
	@Test
    public void LoginFailUserName() {

		String url = "http://localhost:7080/login";
		LoginWebDriver loginWebDriver = new LoginWebDriver();
		WebDriver driver = loginWebDriver.Login(url);
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password =  driver.findElement(By.id("password"));
		WebElement loginButton =  driver.findElement(By.xpath("//button[@class='radius']"));
		
		username.sendKeys("wrong");
		password.sendKeys("wrong!");
		loginButton.click();
	    
	    String actualResult = driver.findElement(By.xpath("//div[@id='flash']")).getText();
	    String expectedResult = "Your username is invalid!";  	
	    Assert.assertTrue(actualResult.contains(expectedResult));
	    driver.close();

	}
	
	@Test
    public void LoginFailPassword() {

		String url = "http://localhost:7080/login";
		LoginWebDriver loginWebDriver = new LoginWebDriver();
		WebDriver driver = loginWebDriver.Login(url);
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password =  driver.findElement(By.id("password"));
		WebElement loginButton =  driver.findElement(By.xpath("//button[@class='radius']"));
		
		username.sendKeys("tomsmith");
		password.sendKeys("wrong!");
		loginButton.click();
	    
	    String actualResult = driver.findElement(By.xpath("//div[@id='flash']")).getText();
	    String expectedResult = "Your password is invalid!";  	
	    Assert.assertTrue(actualResult.contains(expectedResult));
	    driver.close();

	}

}
