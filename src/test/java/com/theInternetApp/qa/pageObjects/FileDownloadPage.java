package com.theInternetApp.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.theInternetApp.qa.Utilities.BaseClass;
import com.theInternetApp.qa.Utilities.WaitHelper;

/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
  public class FileDownloadPage extends BaseClass {

		// The following Initialization of the Page factory
		public FileDownloadPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
		// The following are Declaration the web elements
	
		@FindBy(xpath = "//a[text()=\"File Download\"]")
		@CacheLookup
		WebElement FileDownloadLink;
	
		@FindBy(xpath = "//a[contains(text(),'some-file.txt')]")
		@CacheLookup
		WebElement DownloadLink;
	
	
		// The following are the Utilizations by creating methods for each of the
		// components.
	
		// get URL
		public void getUrl() {
			driver.get(Base_URL);
			FileDownloadLink.click();
		}
	
		// click On DownloadLink
		public void clickOnDownloadLink() {
			DownloadLink.click();
		}
	
	}
