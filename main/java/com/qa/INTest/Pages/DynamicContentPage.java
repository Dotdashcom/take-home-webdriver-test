package com.qa.INTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.INTest.TestBase.TestBase;

public class DynamicContentPage extends TestBase {

	@FindBy(linkText = "Dynamic Content")
	WebElement dynamicContent;

	@FindBy(xpath = "(//div[@class='row'])[4]")
	WebElement firstCont;

	@FindBy(xpath = "//div[contains(text(),'Nam voluptas doloremque minus tenetur molestiae re')]")
	WebElement secondCont;

	public DynamicContentPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickDynamicContentLink() {
		dynamicContent.click();

	}

	public void getDynamicContent() {
		String firstTime = firstCont.getText();
		System.out.println(firstTime);
		System.out.println("<----------------Refresh--------------->");
		driver.navigate().refresh();
		String secondTime = firstCont.getText();
		System.out.println(secondTime);

		if (firstTime.equals(secondTime)) {
			System.out.println("Page didn't refresh properly.");
		} else {
			System.out.println("Yes, content is changed after refresh");
		}
		

	}

}
