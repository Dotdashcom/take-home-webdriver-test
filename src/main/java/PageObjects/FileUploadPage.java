package PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class FileUploadPage extends BrowserUtilities {

	public FileUploadPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='file-upload']")
	WebElement bt_chooseFile;
	
	@FindBy(how = How.ID, using = "drag-drop-upload")
	WebElement dragAndDropFile;
	
	@FindBy(how = How.ID, using = "file-submit")
	WebElement bt_Upload;	
	
	@FindBy(how = How.ID, using = "//h3[contains(text(),'File Uploaded!')]")
	WebElement fileUploadedText;	
	

	public void getUrl() {
		driver.get(BaseTest.getURL("upload"));
	}
	
	public void file_Upload() {

		String currentDir = System.getProperty("user.dir");
		System.out.println("Current dir using System:" + currentDir);
		String testFile = currentDir + "\\TestUploadFile\\TestFile.txt";
		JavascriptExecutor js = (JavascriptExecutor)BaseTest.driver;
		js.executeScript("arguments[0].scrollIntoView(true);",dragAndDropFile );
		dragAndDropFile.click();
		Robot rb;
		try {
			rb = new Robot();
			rb.delay(2000);
			//put path to file in a clipboard
			StringSelection ss = new StringSelection(testFile);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			
			//CTRL+V
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.delay(2000);
			
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.delay(2000);
			
			//Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			bt_Upload.click();
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
