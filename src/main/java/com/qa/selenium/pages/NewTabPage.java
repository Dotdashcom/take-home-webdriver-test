package com.qa.selenium.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class NewTabPage  extends TestBase{
	//String tab;
	
	@FindBy (xpath = "//a[text()='Click Here']")
	WebElement link;
	
	@FindBy (xpath = "//h3[text()='New Window']")
	WebElement newWindowText;
	
	
	
	public NewTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void window() {
		link.click();
		
		Set<String> multipleWindows = driver.getWindowHandles();
		
		
		Iterator<String> it = multipleWindows.iterator();
		
			if (it.hasNext()) {
					System.out.println("This is the name of child window= "+ it.next());
					// this.tab = it.next().toString();
	}
			driver.switchTo().window(it.next());
		//	driver.switchTo().window(this.tab);

	}
	
	public String windowText() {
		return newWindowText.getText();
	}


}
