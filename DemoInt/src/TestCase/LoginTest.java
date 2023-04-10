package TestCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://localhost:7080/login");
		
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }
 
 
  
  @Test
  public void loginSuccess() {
	  
	  loginPageObjects login = new loginPageObjects(driver);
	  login.username.sendKeys("tomsmith");
	  login.password.sendKeys("SuperSecretPassword!");
	  login.Login.click();
	  String expectedUrl = "http://localhost:7080/secure";
	  String actualUrl = driver.getCurrentUrl();
	  
	  Assert.assertEquals(actualUrl, expectedUrl);

	  
  }
  
  
  @Test
  public void loginFailure() {
  
	  loginPageObjects login = new loginPageObjects(driver);
		  login.username.sendKeys("tomsmithgf");
		  login.password.sendKeys("SuperSecretPassword!");
		  login.Login.click();
		 String actualFlashMessage = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
		 String expectedFlashMessage = "Your username is invalid!\n"
		 		+ "×";
		 Assert.assertEquals(actualFlashMessage, expectedFlashMessage);

  		}
}

