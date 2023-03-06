package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BaseTemplate{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By userName = By.name("username");
	By password = By.name("password");
	By titleText =By.className("barone");
	By login = By.className("radius");
	By message = By.id("flash");
	
	public WebElement getLoginMessage()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message));
		return driver.findElement(message);
	}
	
	
	public void setUserName(String strUserName){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userName));
		driver.findElement(userName).sendKeys(strUserName);;
	}
	

	public void setPassword(String strPassword){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(password));
		 driver.findElement(password).sendKeys(strPassword);
	}
	

	public void clickLogin(){
		wait.until(ExpectedConditions.elementToBeClickable(login));
			driver.findElement(login).click();
	}
	
	
	public void loginToInternet(String strUserName,String strPasword){

		setUserName(strUserName);
		setPassword(strPasword);
		clickLogin();		
		
	}

}
