package com.arthi.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arthi.automation.common.PageBase;

public class DynamicControlsPage  extends PageBase {

	private static final String Base_URl = "http://localhost:7080/dynamic_controls";
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkbox; 
	
	@FindBy(xpath="//form//button[@type='button']")
	private List<WebElement> btn;
	
	
	@FindBy(xpath="//form[@id='checkbox-example']//p")
	private WebElement itsGoneLbl;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement enableText;
	
	
	@FindBy(xpath="//form[@id='input-example']//p")
	private WebElement itsenableLbl;
	
	public DynamicControlsPage(WebDriver driver) {
		super(driver);
	}
	
	public DynamicControlsPage navigateToDynamicControlPage() {
		driver.get(Base_URl);
		return this;
	}
	
	public DynamicControlsPage verifyRemoveEvent(final String removeLable) {
		click(btn.get(0), "Remove");
		assertEquals(itsGoneLbl, removeLable);
		return this;	
	}
	
	public DynamicControlsPage verifyEnableEvents() {
		click(btn.get(1), "enable");
		 enableText.sendKeys("Arthi");
		//assertEquals(enableText, "Arthi");
		assertEquals(itsenableLbl,"It's enabled!" );
		
		return this;
		
	}
}
