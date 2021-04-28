package com.automation.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DynamicContentPage {
	public static final By DYNAMICCONTENTHEADER=By.xpath("//h3[text()='Dynamic Content']");
	public static final By CONTENTS=By.xpath("//div[@class='large-10 columns']");
	
	public static void validateDynamicContentHeader(WebDriver driver) {
		WebElement element= driver.findElement(DYNAMICCONTENTHEADER);
		Assert.assertTrue(element.isDisplayed(), "Dynamic Content Header is not Displaying");

	}
	
	public static void refreshContentAndValidate(WebDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> elementsBefore= driver.findElements(CONTENTS);
		List<String> textList= new ArrayList<String>();
		for(int i=0;i<elementsBefore.size();i++) {
			textList.add(elementsBefore.get(i).getText());
		}
	
		
		driver.navigate().refresh();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> elementsAfter= driver.findElements(CONTENTS);
		for(int i=0;i<elementsAfter.size();i++) {
		
			Assert.assertTrue(!textList.contains(elementsAfter.get(i).getText()), "content is matching");
		}
		
	}

}
