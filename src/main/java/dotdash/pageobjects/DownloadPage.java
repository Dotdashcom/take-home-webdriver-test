package dotdash.pageobjects;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DownloadPage {

public WebDriver driver;
	
	

	@FindBy(xpath="//div[@class='example']/a")
	private WebElement download;
	
	
	
	public DownloadPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void downloadFileAndVerifyFileExists() throws InterruptedException  {
		
		download.click();
		Thread.sleep(1000);
		File f=new File(System.getProperty("user.dir")+"/some-file.txt");
		Assert.assertTrue(f.exists());
		if(f.delete()) {
			System.out.println("file deleted");
		} else {
			System.out.println("Error Deleting the file");
			}
		
	}

}
