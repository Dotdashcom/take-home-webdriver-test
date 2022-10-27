package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class UploadPage extends Page {

	public UploadPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By uploadBtn = By.cssSelector("input#file-submit");
	private By chosseFileBtn = By.cssSelector("input#file-upload");
	private By uploadConfirmationMsg = By.cssSelector("div#content h3");

	public void uploadFile(String filePath) {
		((ProxyDriver) wd).sendKeys(chosseFileBtn, filePath);
	}

	public void clickuploadBtn() {
		((ProxyDriver) wd).click(uploadBtn);
	}

	public String getuploadConfirmationMsg() {
		return ((ProxyDriver) wd).getText(uploadConfirmationMsg);
	}

}
