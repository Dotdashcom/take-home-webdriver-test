package com.localhost7080.ddm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dotdashmeredith.base.Base_DDM;

public class ObjectsAndMethods extends Base_DDM {

	public ObjectsAndMethods(WebDriver driver) {
		super(driver);
	}

	// Objects
	By loginInput = By.id("username");
	By loginPassword = By.cssSelector("input[type='password']");
	By loginBtn = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
	By loginSuccess = By.xpath("//div[@class='example']/h2");
	By loginFailure = By.xpath("//div[@id='flash']");

	// Methods
	
	public void enterCredentials(String user, String password, String expected) {
		reporter("Login and validating..");
		sendKeys(loginInput, user);
		sendKeys(loginPassword, password);
		click(loginBtn);
		String text = getText(loginSuccess);
		textAssert(text, expected);
	}
	
	public void enterWrongCredentials(String user, String password, String expected) {
		reporter("Login and validating..");
		sendKeys(loginInput, user);
		sendKeys(loginPassword, password);
		click(loginBtn);
		String[] text = getText(loginFailure).split("!");
		textAssert(text[0], expected);
	}
	
}
