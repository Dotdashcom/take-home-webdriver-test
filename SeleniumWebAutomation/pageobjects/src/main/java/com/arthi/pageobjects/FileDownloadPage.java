package com.arthi.pageobjects;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.arthi.automation.common.PageBase;

public class FileDownloadPage extends PageBase {
	
	private static final String Base_URL="http://localhost:7080/download";
	
	File folder;
	
	@FindBy (xpath="//div[@class='example']//a")
	private List<WebElement> filelists;
	
	public FileDownloadPage(WebDriver driver, final String downloadDir) {
		super(driver);
		this.folder = new File(downloadDir);
	}
	
	public FileDownloadPage navigateToFileDownloadPage() {
		driver.get(Base_URL);
		return this;	
	}
	
	public FileDownloadPage verifyFiledownloadEvent(final String fileToDOwnload) throws InterruptedException {
		boolean found = false;
		for(WebElement filelink : filelists) {
			if (found = filelink.getText().equals(fileToDOwnload)) {
				click(filelink, fileToDOwnload);
				break;
			}
		}
		Assert.assertTrue(found);
		Thread.sleep(2000);
		boolean downloaded = false;
		if (folder.isDirectory()) {
			File listOfFiles[] = folder.listFiles();
			for(File file: listOfFiles) {
				downloaded = file.getName().equals(fileToDOwnload);
			}
		}
		Assert.assertTrue(downloaded);
		return this;
	}
	

}
