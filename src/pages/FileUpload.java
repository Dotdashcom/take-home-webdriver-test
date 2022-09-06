package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FileUpload extends Driver {
	
			//Locators
			public static By upload = By.xpath("//input[@id='file-upload']");
			public static By Submit =By.xpath("//input[@id='file-submit']");
			public static By FileUploaded = By.xpath("//h3[contains(text(),'File Uploaded!')]");
			
		
			// Navigate to Upload page
			public static void NavigateToUploadPage()
			{

				Driver.Instance.get(Baseurl+"//upload");
			
			}
			
			//Upload image using senkeys
			public static void FileUpload(){
				WebElement upload_file = Driver.Instance.findElement(upload);

				upload_file.sendKeys("C:\\WebdriverTest\\image1.png");
				Driver.Instance.findElement(Submit).click();
			}
			
			public static boolean ValidateFileUpload() {
				return Driver.Instance.findElement(FileUploaded).isDisplayed();
			}
			

}
