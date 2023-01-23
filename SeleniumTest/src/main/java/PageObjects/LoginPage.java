package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import AbstractComponents.AbstractClass;

public class LoginPage extends AbstractClass {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement usernametextbox;
	@FindBy(id = "password")
	WebElement passwordtextbox;
	@FindBy(css = ".radius")
	WebElement loginbutton;
	@FindBy(css = ".flash.success")
	WebElement header;
	@FindBy(css = ".flash.error")
	WebElement failheader;

	@Test
	public SecureAreaPage LoginSuccess() {
		usernametextbox.sendKeys("tomsmith");
		passwordtextbox.sendKeys("SuperSecretPassword!");
		loginbutton.click();
		SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
		return secureAreaPage;

	}

	public String getheaderText() {
		String succesmessage = header.getText();
		String[] fullmessage = succesmessage.split("!");
		String actualsuccessmessage = fullmessage[0];
		return actualsuccessmessage;

	}

	public void LoginFail() {
		usernametextbox.sendKeys("tomsmith");
		passwordtextbox.sendKeys("SuperSecretPassword");
		loginbutton.click();

	}

	public String getfailheaderText() {
		String failmessage = failheader.getText();

		String[] fullfailmessage = failmessage.split("!");
		String actualfailsmessage = fullfailmessage[0];
		return actualfailsmessage;

	}

}
