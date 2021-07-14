package com.theInternetPages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class FileDownloadPage extends BasePage{
	
	WebDriver obj_Driver;
	String fileDownloadTitle = "//h3[text()='File Downloader']";
	String fileLink = "(//div[@class='example']/a)[1]";
	
	
	public FileDownloadPage(WebDriver driver) {
		super(driver);
		this.obj_Driver = driver;
		// TODO Auto-generated constructor stub
	}
	public void isDisplayedPage() {
		explicitWait(fileDownloadTitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(fileDownloadTitle)).size()>0,"file Download page is displayed");
	}

	public void clickFileLnk() {
		click(fileLink,"File link");
	}
	
	public String getFileName() {
		return obj_Driver.findElement(By.xpath(fileLink)).getText();
	}
	
}
