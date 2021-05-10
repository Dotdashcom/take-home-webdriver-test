package com.dotdash.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DownloadPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/download";
	private WebElement downloadLink;

	public DownloadPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		downloadLink = driver.findElement(By.cssSelector("a[href='download/some-file.txt']"));
		assertTrue(downloadLink.isDisplayed());
	}

	public void downloadFile() {
		downloadLink.click();
	}
}
