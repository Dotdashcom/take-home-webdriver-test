package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class Login_Fail extends BaseClass {
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sbtn;
	@FindBy(xpath = "//a[@class='button secondary radius']")
	WebElement lgoutBtn;
	public  Login_Fail() {
		PageFactory.initElements(driver, this);
	}
	public void typeemail(String name) {
		username.sendKeys(name);
	}
	public void typepassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickbtn() {
		sbtn.click();
	}
	public void logoutbtn() {
		lgoutBtn.click();
	}

}
