package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class DownloadPage extends Page {

	public DownloadPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By downloadBtn = By.cssSelector("div.example a");

	public void clickdownloadBtn() {
		((ProxyDriver) wd).click(downloadBtn);
	}

}
