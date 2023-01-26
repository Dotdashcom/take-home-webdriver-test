package com.qa.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class DynamicControlPage extends TestBase{

	
	@FindBy (css = "form[id='checkbox-example']>button")
	WebElement addRemoveBtn;
	
	@FindBy (css = "form[id='checkbox-example']>p")
	WebElement addremoveText;
	
	
	@FindBy (css = "form[id='input-example']>button")
	WebElement enableDisableBtn;
	
	@FindBy (css = "form[id='input-example']>p")
	WebElement enabledisableText;
	
	@FindBy (xpath = "//input[@type=\"checkbox\"]")
	WebElement checkBox;
	
	@FindBy (xpath = "//form[@id=\"input-example\"]/input")
	WebElement enabledtextBox;
	
	@FindBy (xpath = "//input[@type=\"text\"][@disabled=\"\"]")
	WebElement disabledtextBox;
	
	
	public DynamicControlPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void AddAndRemoveClick() {
		addRemoveBtn.click();
	}
	
	public void EnableAndDisableClick() {
		enableDisableBtn.click();
	}
	public WebElement addremovelocator() {
		return addRemoveBtn;
	}
	public WebElement enableDisablelocator() {
		return enableDisableBtn;
	}
	public String addremoveText() {
		return addremoveText.getText();
	}
	public String enabledisableText() {
		return enabledisableText.getText();
	}
	
	public WebElement checkbox() {
		return checkBox;
	}
	
	public WebElement textboxPresent() {
		return enabledtextBox;
	}
	public WebElement textboxNotPresent() {
		return disabledtextBox;
	}
	
}
