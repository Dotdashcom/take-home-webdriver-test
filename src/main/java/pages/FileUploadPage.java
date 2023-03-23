package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage extends BaseClass {
	boolean uploaded;
	public FileUploadPage(){
		PageFactory.initElements(driver, this);
	}
 @FindBy(xpath="//*[@id='file-upload']")
 private WebElement chooseFile;
 @FindBy(xpath="//*[@id='file-submit']")
 private WebElement fileUpload;
 @FindBy(xpath="//*[@id='uploaded-files']")
 private WebElement uploadTest;
 
 public boolean uploadFile() {
	 chooseFile.sendKeys("C:\\Users\\rajee\\Downloads\\some-file.txt");
	 fileUpload.click();
	 String uploadText =uploadTest.getText();
	 if(uploadText.contains("some-file")) {
		  uploaded = true;
	 }
	 else {
		 uploaded = false;
	 }
	 return uploaded;
 }
}
