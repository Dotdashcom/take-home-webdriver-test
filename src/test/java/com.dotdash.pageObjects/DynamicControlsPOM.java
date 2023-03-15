package com.dotdash.pageObjects;

import java.awt.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotdash.testUtils.TestBase;


public class DynamicControlsPOM extends TestBase {
	@FindBy(css="form#checkbox-example>button")
	WebElement removeButton;

	@FindBy(css="div#checkbox")
	WebElement checkBox;

	@FindBy(css="form#checkbox-example>button")
	WebElement AddButton;

	@FindBy(css="input#checkbox")
	WebElement checkBox2;
	
	@FindBy(css="form#input-example>button")
	WebElement EnableButton;
	
	@FindBy(css="form#input-example>input")
	WebElement TextBox;
	
	@FindBy(css="form#input-example>button")
	WebElement DisableButton;
	
	public DynamicControlsPOM() {
		
		PageFactory.initElements(driver,this);
	}
	
	public void userclickRemoveButton() {
		removeButton.click();
	}
	
	public boolean usercheckboxnotfound() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		boolean status=wait.until(ExpectedConditions.invisibilityOf(checkBox));
		return status;
	
	}
	public void userclickAddButton() {
		AddButton.click();
	}
	public boolean usercheckboxPresent() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(checkBox2));
		boolean checkBoxDisplayed= checkBox2.isDisplayed();
		return checkBoxDisplayed;		
	}
	public void userclickEnableButton() {
		EnableButton.click();
	}
	
	public boolean usercheckTextBoxEnabled() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBePresentInElement(DisableButton, "Disable"));
		boolean status=TextBox.isEnabled();
		return status;
		
	}
	public void userclickDisableButton() {
		DisableButton.click();
	}
	public boolean usertextBoxDisabled() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBePresentInElement(DisableButton, "Enable"));	
		boolean status=TextBox.isEnabled();
		return status;
	}
	
	
	
}
