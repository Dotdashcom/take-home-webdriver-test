package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;

	@FindBy(id="username")
	WebElement username;


	@FindBy(id="password")
	WebElement password;

	@FindBy(xpath="//i[@class='fa fa-2x fa-sign-in']")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void printUsername(String actualUser) {
			username.sendKeys(actualUser);
			}
	public void printPassword(String actualPassword) {
		password.sendKeys(actualPassword);
		}
	public void clickLogin() {
		loginButton.click();
		}

}
