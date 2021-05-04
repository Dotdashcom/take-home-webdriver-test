package com.arthi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arthi.automation.common.PageBase;

/**
 * 
 * @author Arthina Kumar
 *
 */
public class LoginSuccessPage  extends PageBase{
	
	private static final String Base_URL = "http://localhost:7080/login";
	
	@FindBy(id="username")
	private WebElement usernameTxt;
	
	@FindBy(id="password")
	private WebElement passwordTxt;
	
	@FindBy(id="flash")
	private WebElement errorMessageUsernameLbl;
	
	@FindBy(id="flash")
	private WebElement errorMessagePasswordLbl;
	
	@FindBy(xpath="//div[@class='example']//h2")
	private WebElement centerTextCheck;
	
	
	public LoginSuccessPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginSuccessPage navigateToLoginSuccessPage() {
		driver.get(Base_URL);
		return this;
		
		
	}
	
	public SecureAreaPage loginToSecureArea(final String userName, final String password) {
		writeText(usernameTxt, userName);
		writeText(passwordTxt, password);
		submitForm(passwordTxt);
		SecureAreaPage secureAreaPage =  new SecureAreaPage(driver);
		secureAreaPage.verifyPageLable("Secure Area");
		return secureAreaPage;
	}
	
	public LoginSuccessPage tryLoginPage(final String userName, final String password) {
		writeText(usernameTxt, userName);
		writeText(passwordTxt, password);
		submitForm(passwordTxt);	
		return this;
		
	}
	
	//Verify error Validation method
	public LoginSuccessPage verifyInvalidUserName(String expectedText) {
		assertContains(errorMessageUsernameLbl, expectedText);
		return this;
	}
	public LoginSuccessPage verifyInvalidPassword(String expectedText) {
		assertContains(errorMessagePasswordLbl, expectedText);
		//assertEquals(errorMessagePasswordLbl, expectedText);
		return this;	
	}
	
	public LoginSuccessPage verifyCenterWelcomeText(String expectedText) {
		assertContains(centerTextCheck, expectedText);
		//assertEquals(centerTextCheck, expectedText);
		return this;
	}
	

	

}
