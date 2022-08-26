package page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import util.BrowserFactory;



public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='username']")WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")WebElement SIGNIN_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//div[@id='flash']")WebElement LOGINSUCCESS_ELEMENT;
	
	public void insertUserName(String userName) {
		USER_NAME_ELEMENT.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickSiginButton() {
		SIGNIN_ELEMENT.click();
	}
	
	public void validateLogin() {
		String actualResult = "The Internet";
		String expectedResult = driver.getTitle();
		
		System.out.println(actualResult);
		System.out.println(expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
		
	}
}
