package com.qa.dotdash.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dotdash.utils.Proxywrapper;

public class FileDownloadPage extends Page {
	private static final String PAGE_URL = "/download";

	public FileDownloadPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By link = By.cssSelector("#content  div  a:nth-child(4)");

	public void clickLink() {
		((Proxywrapper) driver).click(link);
	} 

}
