package page;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DownloadNewFilePage {

	WebDriver driver;
	private static String filePath = "C:\\Users\\13136\\Downloads\\";
	private static String fileName = "some-file.txt";

	public DownloadNewFilePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'File Download')]")
	WebElement FILEDOWNLOAD_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'some-file.txt')]")
	WebElement FILE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id='uploaded-files']")
	WebElement CHECK_ELEMENT;

	// goint to download link
	public void downloadMenu() {

		FILEDOWNLOAD_MENU_ELEMENT.click();

	}

	// downloading text file
	public void downloadFile() throws InterruptedException {

		System.out.println("Before download file exists:" + isFileExists(filePath + fileName));
		FILE_ELEMENT.click();
		Thread.sleep(4000);
		System.out.println("After download file exists:" + isFileExists(filePath + fileName));
	}

	//checking if the file exists
	public boolean isFileExists(String filePath) {
		File newFile = new File(filePath);
		if (newFile.exists()) {
			return true;
		} else
			return false;

	}

}
