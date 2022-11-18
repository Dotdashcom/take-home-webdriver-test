package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SecurePage {
	
private WebDriver driver;
	
	public SecurePage(WebDriver driver) {		
		this.driver = driver;
	}
	
	By subHeader = By.cssSelector(".subheader");
	
	public void VerifyHeading() {
		String actual = "Welcome to the Secure Area. When you are done click logout below.";		
		Assert.assertEquals(actual, driver.findElement(subHeader).getText());
	}

}
