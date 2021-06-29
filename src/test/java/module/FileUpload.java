package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import configuration.PageLoader;

public class FileUpload {
	private WebDriver driver = null;
	
	@FindBy(how=How.ID, using="file-upload")
	private WebElement fileInput;
	
	@FindBy(how=How.ID, using="file-submit")
	private WebElement fileSubmit;
	
	public FileUpload(WebDriver driver) {
		this.driver = driver;
		this.loadPage();
		PageFactory.initElements(driver, this);
	}
	
	public void uploadFile(String file) {		
		fileInput.sendKeys(file);
		fileSubmit.click();	
	}
	
	public boolean isUploaded() {
		WebElement message = driver.findElement(By.tagName("h3"));
		if (message.getText().equals("File Uploaded!"))
			return true;
		return false;
	}
	
	public void loadPage() {
		PageLoader.loadPage(driver, "/upload");		
	}	
}
