package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class PomLogin extends BaseClass {

	@FindBy(id = "username") WebElement Username;
	@FindBy(id ="password") WebElement Password;
	@FindBy(xpath = "//*[@id=\"login\"]/button") WebElement LoginBtn;
	@FindBy(id = "flash") WebElement alert;
	
	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
	
	public String verify() {
		return alert.getText();
	}
	
	public void typeusername (String name) {
		Username.sendKeys(name);	
	}
	
	public void password(String password) {
		Password.sendKeys(password);
	}
	
	public void submit() {
		LoginBtn.click();
	}
}
