package com.theInternet.qa.pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicControlsPage {

	WebDriver driver;
	@FindBy(xpath = "//button[normalize-space()='Remove']")
	WebElement Remove_btn;

	@FindBy(xpath = "//p[@id='message']")
	WebElement Remove_msg;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement Add_btn;

	@FindBy(xpath = "//p[@id='message']")
	WebElement Add_msg;

	@FindBy(xpath = "//button[normalize-space()='Enable']")
	WebElement Enable_btn;

	@FindBy(xpath = "//p[@id='message']")
	WebElement Enable_msg;

	@FindBy(xpath = "//button[normalize-space()='Disable']")
	WebElement Disable_btn;

	@FindBy(xpath = " //p[@id='message']")
	WebElement Disable_msg;

	public DynamicControlsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyDynamicControls() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // creating Explicit wait
		Remove_btn.click();
		wait.until(ExpectedConditions.visibilityOf(Remove_msg));
		String Remove_txt = Remove_msg.getText();
		Assert.assertEquals(Remove_txt, "It's gone!");
		// Adding back check box
		Add_btn.click();
		wait.until(ExpectedConditions.visibilityOf(Add_msg));
		String Add_txt = Add_msg.getText();
		Assert.assertEquals(Add_txt, "It's back!");
		Enable_btn.click();
		wait.until(ExpectedConditions.visibilityOf(Enable_msg));
		String Enable_txt = Enable_msg.getText();
		Assert.assertEquals(Enable_txt, "It's enabled!");
		Disable_btn.click();
		wait.until(ExpectedConditions.visibilityOf(Disable_msg));
		String Disable_txt = Enable_msg.getText();
		Assert.assertEquals(Disable_txt, "It's disabled!");

	}

}
