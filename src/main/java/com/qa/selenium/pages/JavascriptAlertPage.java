package com.qa.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.util.TestUtil;

public class JavascriptAlertPage extends TestBase{
	
	@FindBy (xpath = "//*[text()='Click for JS Alert']")
	WebElement jsAlertBtn;
	
	@FindBy (xpath = "//*[text()='Click for JS Confirm']")
	WebElement jsconfirmBtn;
	
	@FindBy (xpath = "//*[text()='Click for JS Prompt']")
	WebElement jspromptBtn;
	
	@FindBy (xpath = "//p[@id='result']")
	WebElement jsPromptresult;
	
	
	public JavascriptAlertPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void jsalert() throws InterruptedException {
		jsAlertBtn.click();
		Thread.sleep(1000);
		TestUtil.JsAlert();
	}
	public void jsconfirm() throws InterruptedException {
		jsconfirmBtn.click();
		Thread.sleep(1000);
		TestUtil.JsConfirm();
	}
	
	public void jspropmpt() throws InterruptedException {
		jspromptBtn.click();
		Thread.sleep(1000);
		TestUtil.JsPrompt();
	}
	public String jsPromptResult() {
		return jsPromptresult.getText().substring(13);
	}


}
