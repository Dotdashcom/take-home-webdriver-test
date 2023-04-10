package navpreet.pageobjects;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadPageObjects {

	WebDriver driver;
	Robot rb;
	WebDriverWait wait;

	
	public FileUploadPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='File Upload']")
	private WebElement click_file_upload;
	
	@FindBy(css="#file-upload")
	private WebElement choose_file;
	
	@FindBy(id="file-submit")
	private WebElement upload_button;

	@FindBy(xpath="//div/h3")
	private WebElement upload_message;

	
	public void Click_FileUpload()
	{
		click_file_upload.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30000));
		wait.until(ExpectedConditions.visibilityOf(choose_file));
	}
	
	public void Choose_File() throws InterruptedException
	{
		choose_file.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(900000));
	}
		
	public String Get_Message()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		return upload_message.getText();
	}
	
	public void UploadingFile() throws IOException
	{
		//String filePath=System.getProperty("user.dir")+"\\Downloads\\"+filename;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Downloads\\ScriptAutoIt.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		upload_button.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
	  
	    
}
}