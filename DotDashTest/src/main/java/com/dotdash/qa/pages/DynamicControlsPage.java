package com.dotdash.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotdash.qa.base.TestBase;

public class DynamicControlsPage extends TestBase {
	
	@FindBy(xpath="//div[@id='checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement removeBtn;
	
	@FindBy(xpath = "//form[@id='input-example']//input")
	WebElement textBox;
	
	@FindBy(xpath = "//button[contains(text(),'Enable')]")
	WebElement enableBtn;
	
	public DynamicControlsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean removeCheckBox() {
		removeBtn.click();
		boolean b = checkBox.isDisplayed();
		System.out.println("Check Box Removed : " + b);
		return b;
	}
	
	public boolean enableTextBox() {
		enableBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 
		// Here we will wait until element is not visible, if element is visible then it will return web element
		// or else it will throw exception
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='input-example']//input")));
		boolean b = element.isEnabled();
		System.out.println("Text Box Enabled : " + b);
		return b;
	}
	

}
