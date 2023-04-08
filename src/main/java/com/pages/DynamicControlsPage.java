package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;

public class DynamicControlsPage extends Base{
	
	@FindBy(xpath="//button[@onclick='swapCheckbox()']")
	WebElement addOrRemoveBtn ;
	
	@FindBy(xpath="//form[@id='checkbox-example']//div[1]")
	WebElement checkbox ;
	
	@FindBy(xpath="//p[@id='message']")
	WebElement message ;
	
	@FindBy(xpath="//button[@onclick='swapInput()']")
	WebElement enableAndDisableBtn ;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement textField ;
	
	public DynamicControlsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddOrRemoveBtn() {
		addOrRemoveBtn.click();
	}
	public void explicitWaitAfterRemoveButton() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(message,"It's gone!"));
	}
	public void explicitWaitAfterAddButton() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(message,"It's back!"));
	}
	
	public String getMessageText() {
		String msg=message.getText();
		return msg;
	}
	
	public boolean messageIsDisplayed() {
		boolean flag=message.isDisplayed();
		return flag;
	}
	
	public void clickOnEnableAndDisableBtn() {
		enableAndDisableBtn.click();
	}
	public void explicitWaitAfterEnableButton() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(message,"It's enabled!"));
	}
	public void explicitWaitAfterDiableButton() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(message,"It's disabled!"));
	}
	public boolean checkTextFieldIsEnabled() {
		boolean flag=textField.isEnabled();
		return flag;
	}
}
