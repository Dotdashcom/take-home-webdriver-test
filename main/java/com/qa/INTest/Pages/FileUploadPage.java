package com.qa.INTest.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.INTest.TestBase.TestBase;

public class FileUploadPage extends TestBase {

	@FindBy(linkText = "File Upload")
	WebElement fileUpload;

	@FindBy(xpath = "//input[@id='file-upload']")
	WebElement chooseFileBtn;

	@FindBy(xpath = "//input[@id='file-submit']")
	WebElement uploadFileBtn;

	// input[@id='file-submit']
	public FileUploadPage() {

		PageFactory.initElements(driver, this);

	}

	public void clickOnFileUpload() {
		fileUpload.click();

	}

	public void clickOnChooseFileBtn() throws IOException, InterruptedException, AWTException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", chooseFileBtn);

		// Runtime.getRuntime().exec("C://Users//jemis//Desktop//FileUploadScript.exe");

		Thread.sleep(2000);

		Robot rb = new Robot();
		rb.delay(2000);

		StringSelection filePath = new StringSelection(
				"C:\\SeleniumCopy\\Selenium_WorkSpace_Copy\\InterviewTestPOM\\some-file.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		uploadFileBtn.click();
	}

}
