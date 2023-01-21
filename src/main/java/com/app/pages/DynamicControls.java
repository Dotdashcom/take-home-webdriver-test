package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.util.PageLinks;

public class DynamicControls extends BasePage {

	public DynamicControls(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addBtn;
	
	@FindBy(xpath = "//button[text()='Remove']")
	private WebElement removeBtn;
	
	@FindBy(xpath = "//button[text()='Enable']")
	private WebElement enableBtn;
	
	@FindBy(xpath = "//button[text()='Disable']")
	private WebElement disableBtn;
	
	@FindBy(id = "loading")
	private WebElement loaderSpinner;
	
	@FindBy(id = "message")
	private WebElement message;
	
	@FindBy(xpath = "//form[@id='input-example']/input")
	private WebElement inputField;
	
	public void visitDynamicControlsPage() {
		getDriver().get(PageLinks.DYNAMIC_CONTROLS_PAGE);
	}
	
	public void verifyDynamicControls() throws InterruptedException {
		WebDriver driver = getDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
	
		removeBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loaderSpinner));	
		assertEquals("It's gone!", message.getText().trim());
		assertTrue(addBtn.isDisplayed());
		Thread.sleep(1000);
		//-------------
		
		addBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loaderSpinner));
		assertEquals("It's back!", message.getText().trim());
		assertTrue(removeBtn.isDisplayed());
		Thread.sleep(1000);
		
		driver.navigate().refresh(); //there is a problem on the page, if we click two buttons at the same time
		
		
		assertTrue(inputField.isDisplayed()); //disabled first time
		
		enableBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loaderSpinner));
		assertEquals("It's enabled!", message.getText().trim());
		assertTrue(inputField.isEnabled());
		Thread.sleep(1000);
		
		disableBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loaderSpinner));
		assertEquals("It's disabled!", message.getText().trim());
		assertTrue(inputField.isDisplayed());
		Thread.sleep(1000);
	}
	
	
}
