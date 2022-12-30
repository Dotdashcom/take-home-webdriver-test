package com.takehome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenu {
	
	WebDriver driver;
	
	@FindBy(id="menu") WebElement floatingMenu;
	
	
	public FloatingMenu(WebDriver driver, String baseurl) {
		this.driver = driver;
		String url = baseurl + "/" +"floating_menu";
		driver.get(url);
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getFloatingMenu()
	{
		return floatingMenu;
	}

}
