package com.theInternetPages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DynamicContentPage extends BasePage {

	WebDriver obj_Driver;
	String dynamicContetTitle = "//h3[text()='Dynamic Content']";
	String list = "//div[@id='content']/div[@class='row']";
	String listValues = "(//div[@class='large-10 columns'])[VR]";

	public DynamicContentPage(WebDriver driver) {
		super(driver);
		this.obj_Driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void isDisplayedPage() {
		explicitWait(dynamicContetTitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(dynamicContetTitle)).size() > 0,
				"dynamic Contet page is displayed");
	}

	public ArrayList<String> getListData() {

		ArrayList<String> data = new ArrayList<String>();
		for (int i = 1; i < obj_Driver.findElements(By.xpath(list)).size(); i++) {
			String text = obj_Driver.findElement(By.xpath(listValues.replace("VR", String.valueOf(i)))).getText();
			data.add(text);
		}

		return data;

	}

}
