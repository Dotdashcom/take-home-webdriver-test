package navpreet.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FileDownloadPageObjects {

	WebDriver driver;
	public FileDownloadPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='File Download']")
	private WebElement click_file_download;
	
	@FindBy(xpath="//div[@class='example']/a")
	private WebElement file_name;
	
	public void Click_FileDownload()
	{
		click_file_download.click();
	}
	
	public void Click_FileName() throws AWTException
	{
		file_name.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
	}
	
	public boolean VerifyFileDownload() throws IOException
	{       
		String filename=file_name.getText();
		String downloadLocation=System.getProperty("user.dir")+"\\Downloads\\"+filename;
		System.out.println(downloadLocation);
		File file=new File(downloadLocation);
		FileUtils.copyURLToFile(new URL(file_name.getAttribute("href")),file);	
        return file.exists();
	}
	
	
	
}
