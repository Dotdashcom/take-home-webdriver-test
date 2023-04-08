package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class OpenInNewTabPage extends Base{
	
	@FindBy(linkText="Click Here")
	WebElement clickHereBtn;
	
	@FindBy(xpath="//body//div//h3")
	WebElement newWindowText;
	
	public OpenInNewTabPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnClickHereLink() {
		clickHereBtn.click();
		Set<String> handles=driver.getWindowHandles();
		List<String> tabList= new ArrayList<String>(handles);
		if(switchToNewTab("New Window",tabList)) {
			System.out.println(driver.getCurrentUrl()+"::"+driver.getTitle());
		}
	}
	
	public boolean switchToNewTab(String tabTitle, List<String>tabList) {
		for(String e: tabList) {
			String title = driver.switchTo().window(e).getTitle();
			if(title.contains(tabTitle)) {
				System.out.println("The New tab Is Opened");
				return true;
			}
		}
		return false;
		
	}
	
	public String getTheTextOnNewTab() {
		String textOnNewWindow=newWindowText.getText();
		return textOnNewWindow;
	}

}
