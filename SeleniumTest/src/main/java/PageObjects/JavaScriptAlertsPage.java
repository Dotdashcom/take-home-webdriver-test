package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class JavaScriptAlertsPage extends AbstractClass {
	WebDriver driver;

	public JavaScriptAlertsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[onclick='jsAlert()']")
	WebElement jsalertbutton;
	@FindBy(css = "button[onclick='jsConfirm()']")
	WebElement jsconfirmbutton;
	@FindBy(id = "result")
	WebElement alertmessage;
	@FindBy(css = "button[onclick='jsPrompt()']")
	WebElement jspromptbutton;

	public String pressjsalert() {
		jsalertbutton.click();
		String alerttext = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alerttext;

	}

	public String pressjsconfirm() {
		jsconfirmbutton.click();
		driver.switchTo().alert().accept();
		String message = alertmessage.getText();
		return message;

	}

	public String pressjsprompt() {
		jspromptbutton.click();
		driver.switchTo().alert().sendKeys("My name is Raman");
		driver.switchTo().alert().accept();
		String mess = alertmessage.getText();
		return mess;

	}

}
