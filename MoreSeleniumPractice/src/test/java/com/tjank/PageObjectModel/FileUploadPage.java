package com.tjank.PageObjectModel;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUploadPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public FileUploadPage() {
		this.URL = this.URL.concat("/upload");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//input[@id='file-upload']")
	public WebElement chooseFileButton;
	
	@FindBy(xpath = "//input[@id='file-submit']")
	public WebElement uploadButton;
	
	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(10));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='File Uploader']")));
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
	
	public void uploadFile(String filename) {
		String path = verifyFilenamePresent(filename);
		actions.moveToElement(chooseFileButton).click().perform();
		waitSeconds(1);
		setClipboardData(path);
		pasteFilename();
		uploadButton.click();
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='File Uploaded!']")));
	}
	
	public String verifyFilenamePresent(String filename) {
		String output = "";
		String home = System.getProperty("user.home") + "\\Downloads\\";
        File file = new File(home);
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].getName().equals(filename)) {
                output = home + fileList[i].getName();
                break;
            }
        }
        return output;
	}
	
	public void setClipboardData(String fileLocation) {
       StringSelection stringSelection = new StringSelection(fileLocation);
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }
	
	public void pasteFilename() {
		try {
			 Robot robot = new Robot();
			 robot.delay(250);
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.delay(250);
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 robot.delay(250);
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.delay(250);
			 robot.keyPress(KeyEvent.VK_V);
		     robot.delay(250);
			 robot.keyRelease(KeyEvent.VK_V);
             robot.delay(250);
			 robot.keyRelease(KeyEvent.VK_CONTROL);
		     robot.delay(190);
		     robot.keyPress(KeyEvent.VK_ENTER);
			 robot.delay(250);
			 robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyFileUploaded(String filename) {
		WebElement el = driver.findElement(By.xpath("//*[@id='uploaded-files']"));
		Assert.assertEquals(el.getText(), filename);
	}
}
