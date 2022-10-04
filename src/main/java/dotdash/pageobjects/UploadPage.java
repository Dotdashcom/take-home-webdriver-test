package dotdash.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UploadPage {
	
public WebDriver driver;
	
	

	@FindBy(id="file-upload")
	private WebElement chooseFile;
	
	@FindBy(id="file-submit")
	private WebElement upload;
	
	
	public UploadPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void uploadFile()  {
		chooseFile.sendKeys(System.getProperty("user.dir")+"/file.txt");
		upload.click();
		Assert.assertTrue((driver.findElements(By.id("uploaded-files"))).size()>0);
	}
	

}
