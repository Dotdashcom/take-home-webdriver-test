package com.arthi.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arthi.automation.common.PageBase;

/**
 * 
 * @author Arthina Kumar
 *
 */
public class CheckBoxPage extends PageBase {
	
	private static final String Base_URL = "http://localhost:7080/checkboxes";
	
	
	@FindBy(xpath="//form//input[@type='checkbox']")
	private List<WebElement> checkboxOptions;

	public CheckBoxPage(WebDriver driver) {
		super(driver);
		
	}
	


	public CheckBoxPage navigateToCheckBoxPage() {
		driver.get(Base_URL);
		return this;		
	}
	
	public CheckBoxPage verifyCheckBoxSelect() {
		for(int i=0;i<checkboxOptions.size();i++) {
			String value1= checkboxOptions.get(i).getAttribute("checkbox 1");
			 while(checkboxOptions.get(i).isSelected()== false) 
				 checkboxOptions.get(i).click();;
			break;
		}
		
		return this;
	}
	
	public CheckBoxPage verifyCheckBoxUnselect() {
		for(int i=0;i<checkboxOptions.size();i++) {
			if(checkboxOptions.get(i).isSelected()) {
				checkboxOptions.get(i).click();
			}break;
		}

		
		return this;
	}
	

}
