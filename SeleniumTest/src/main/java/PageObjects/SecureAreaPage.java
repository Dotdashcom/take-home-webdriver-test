package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class SecureAreaPage extends AbstractClass {

	WebDriver driver;
	@FindBy(css = ".button.secondary.radius")
	WebElement logoutbutton;

	public SecureAreaPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Logout() {
		logoutbutton.click();
	}

}
