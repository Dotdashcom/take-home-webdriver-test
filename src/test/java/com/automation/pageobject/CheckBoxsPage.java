package com.automation.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckBoxsPage {
public static final By CHECKBOXSHEADER=By.xpath("//h3[text()='Checkboxes']");
public static final By CHECKBOXES= By.xpath("//input[@type='checkbox']");

public static void validateCheckBoxsHeader(WebDriver driver) {
	WebElement element= driver.findElement(CHECKBOXSHEADER);
	Assert.assertTrue(element.isDisplayed(), "CHECK BOXS HEADER is not Displaying");

} 

public static void clickCheckBoxes(WebDriver driver) {
	List<WebElement> element= driver.findElements(CHECKBOXES);
	
	
	for(int i=0;i<element.size();i++) {
		if(element.get(i).isSelected()) {
			element.get(i).click();
			Assert.assertFalse(element.get(i).isSelected(), "check box is selected");

		}else {
			element.get(i).click();
			System.out.println("check box value"+element.get(i).isSelected());
			Assert.assertTrue(element.get(i).isSelected(),"Check box is not selected");
			element.get(i).click();
			Assert.assertFalse(element.get(i).isSelected(), "check box is selected");
			
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
}
