package com.tjank.PageObjectModel;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileDownloadPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public FileDownloadPage() {
		this.URL = this.URL.concat("/download");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//a[text()='some-file.txt']")
	public WebElement downloadLink;

	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(10));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='File Downloader']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public void waitSeconds(int num) {
		try {
			Thread.sleep(num * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void downloadFile() {
		downloadLink.click();
		waitSeconds(3);
	}
	
	public void verifyFileDownloaded() {
		boolean flag = false;
		String home = System.getProperty("user.home");
        File file = new File(home + "/Downloads");
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].getName().equals(downloadLink.getText())) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);
	}
	
}
