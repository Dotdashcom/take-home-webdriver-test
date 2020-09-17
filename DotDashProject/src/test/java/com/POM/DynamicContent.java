package com.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DynamicContent {

	WebDriver driver;
	String value1;
	String value2;
	@FindBy(xpath="//div[@class=\"large-10 columns large-centered\"]/div[3]/div[2]")
	WebElement refresh;

	public DynamicContent(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void dynamicContent() {

		refresh.click();


		value1 = refresh.getText();
		System.out.println("The content on first time page refresh" +"\t"+value1);
		refresh.click();


		value2=refresh.getText();
		System.out.println("The content on second time page refresh" +"\t"+value2);
		Assert.assertNotEquals(value1, value2);


	}
}
