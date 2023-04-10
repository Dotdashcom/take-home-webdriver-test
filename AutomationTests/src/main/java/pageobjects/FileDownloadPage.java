package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class FileDownloadPage {
	public WebDriver driver;

	public FileDownloadPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='example']/a")
	private WebElement download;



	public void downloadFileAndVerifyFileExists() throws InterruptedException  {

		download.click();
		Thread.sleep(1000);
		File f=new File(System.getProperty("user.dir")+"//"+"some-file.txt");
		Assert.assertTrue(f.exists());
		if(f.delete()) {
			System.out.println("file deleted");
		} else {
			System.out.println("Error Deleting the file");
			}

	}
		
	}

