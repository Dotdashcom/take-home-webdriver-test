package com.qa.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.selenium.base.TestBase;

public class NotificationMessagePage extends TestBase {

	@FindBy(xpath = "//a[text()='Click here']")
	WebElement link;

	@FindBy(xpath = "//div[@id='flash']")
	WebElement Text;

	public NotificationMessagePage() {
		PageFactory.initElements(driver, this);
	}

	public void linkclick() {
		link.click();
//		System.out.println(linkText());
	}

	public String linkText() {
		return Text.getText();
	}

	public boolean matchNotification1() {
		boolean flag = linkText().contains(prop.getProperty("notification1"));
		return flag;
	}

	public boolean matchNotification2() {
		boolean flag = linkText().contains(prop.getProperty("notification2"));
		return flag;
	}

}
