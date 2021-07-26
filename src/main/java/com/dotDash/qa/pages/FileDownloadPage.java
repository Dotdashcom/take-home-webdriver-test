package com.dotDash.qa.pages;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.dotDash.qa.base.TestBase;

public class FileDownloadPage extends TestBase {

	// Finding the link to the JavaScript Alert page
	@FindBy(xpath = "/html/body/div[2]/div/ul/li[17]/a")
	WebElement null1;

	// Finding download link
	@FindBy(xpath = "//a[@href='download/some-file.txt']")
	WebElement someFile;

	// Initializing the Page Objects:
	public FileDownloadPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// Downloading the file test function
	public boolean fileCheck(String downloadPath) throws InterruptedException {

		null1.click();
		someFile.click();
		File dir = new File(downloadPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return false;
		}

		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().contains("some-file.txt")) {
				return true;
			}
		}
		return false;
	}
}
