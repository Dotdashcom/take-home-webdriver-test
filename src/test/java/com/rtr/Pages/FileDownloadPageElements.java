package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class FileDownloadPageElements extends CommonMethods{

	@FindBy (xpath = "//div[@id=\"content\"]/div/a")
	public WebElement downloadlink;

	
	public FileDownloadPageElements() {
		PageFactory.initElements(driver, this);
	}
}
