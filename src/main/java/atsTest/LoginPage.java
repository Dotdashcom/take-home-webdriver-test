package atsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base{
	WebDriver driver;

	  public LoginPage(WebDriver driver){
	    this.driver = driver;
	  }
	  	    
	   public void browserInitialization() {
		   initializeDriver();			
		}

	   By usernameBy = By.id("username");
	   By passwordBy = By.id("password");
	   By signinBy = By.className("radius"); 

	  
	  public HomePage loginUser(String userName, String password) {
		    driver.findElement(usernameBy).sendKeys(userName);
		    driver.findElement(passwordBy).sendKeys(password);
		    driver.findElement(signinBy).click();
		    return new HomePage(driver);
		  
		  }
}
