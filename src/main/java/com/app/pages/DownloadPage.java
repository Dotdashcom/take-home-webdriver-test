package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.util.PageLinks;

public class DownloadPage extends BasePage {

	public DownloadPage(WebDriver driver) {
		super(driver);
	}

	
	public void visitDownloadPage() {
		getDriver().get(PageLinks.FILE_DOWNLOAD_PAGE);
	}
	
	public void verifyDownloadFile() {
		WebDriver driver = getDriver();
		//temporary solution to download the file into downloads folder.
		String folderName = System.getProperty("user.home") + "/Downloads";
		String uiFilename = "some-file.txt"; //some file name will change on the ui
		deletePreviousFile(folderName, uiFilename); //delete previously save file
		WebElement fileLink = driver.findElement(By.xpath("//a[text()='"+uiFilename+"']"));
		fileLink.click();
		boolean downloaded = isFileDownloaded(folderName, uiFilename);
		assertTrue(downloaded);
	}
	
	private void deletePreviousFile(String path, String fileName) {
		File file = new File(path +"/" + fileName);
		if (file.exists()) {
			file.delete();
		}
	}
	
	private boolean isFileDownloaded(String downloadPath, final String fileName) {
		WebDriver driver = getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		File file = new File(downloadPath +"/" + fileName);
		wait.until((ExpectedCondition<Boolean>) webDriver -> file.exists());
	    File dir = new File(downloadPath);
	    File[] dirContents = dir.listFiles();
	    return Arrays.stream(dirContents).anyMatch(f -> f.getName().equals(fileName));

	}

}
