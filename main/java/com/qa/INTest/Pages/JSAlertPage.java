package com.qa.INTest.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.INTest.TestBase.TestBase;

public class JSAlertPage extends TestBase {

	@FindBy(linkText = "JavaScript Alerts")
	WebElement alertsLink;

	@FindBy(xpath = "//button[@onclick='jsAlert()']")
	WebElement jsAlertBtn;

	@FindBy(xpath = "//button[@onclick='jsAlert()']")
	WebElement jsConfirmBtn;

	@FindBy(xpath = "//button[@onclick='jsPrompt()']")
	WebElement jsPromptBtn;

	public JSAlertPage() {

		PageFactory.initElements(driver, this);

	}

	public void clickOnJSAlert() {
		alertsLink.click();
	}

	public String clickOnJSAlertBtn() {

		jsAlertBtn.click();
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		//al.accept();
		return al.getText();
	}

	public String clickOnJSconfirmBtn() {

		jsConfirmBtn.click();
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		//al.dismiss();
		return al.getText();
	}

	public String clickOnJSPromptBtn() {

		jsPromptBtn.click();
		Alert al = driver.switchTo().alert();
		al.sendKeys("JSPromptAlert");
		System.out.println(al.getText());
		return al.getText();

	}

}
