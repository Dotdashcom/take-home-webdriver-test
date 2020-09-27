/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import base.WebLink;

/**
 * @author choudhuryIqbal
 *
 */
public class FileUploadPage extends BasePage {

	public FileUploadPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id ="file-upload")
	WebElement clickChooseFile;
	
	@FindBy(id="file-submit")
	WebElement submitUpload;
	
	@FindBy(id="uploaded-files")
	WebElement uploadedFiles;


	public void uploadFile() {
		// TODO Auto-generated method stub
		String fileLink=System.getProperty("user.dir");
		clickChooseFile.sendKeys(fileLink+"//uploadfiles//upload.txt");
		submitUpload.submit();
		
	}
	
	public boolean isFileUploaded() {
		return uploadedFiles.getText().equalsIgnoreCase("upload.txt");
	}

}
