package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Page;

public class DynamicContentPage extends Page{
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	
	public String ContentText() {
		return Page.getText(locators.dynamicContent);
	}

}
