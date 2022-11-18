package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class FileUploadPage {
	
	   
		private WebDriver driver;

			public FileUploadPage(WebDriver driver ) {		
				
				this.driver = driver;
			}
			
			By chooseFile=  By.cssSelector("input#file-upload");
			By uploadButton = By.cssSelector("#file-submit");
			By uploadedFile = By.cssSelector("#uploaded-files");
			
			public void VerifyFileUploaded(String fileName) {
				Assert.assertEquals(fileName, driver.findElement(uploadedFile).getText());
			}
			
			public void ClickButton (String button) throws InterruptedException {
				
				switch(button) {
				case "Choose File":
					Thread.sleep(2000);
					driver.findElement(chooseFile).click();
					Thread.sleep(2000);
					break;
					
				case "Upload":
					driver.findElement(uploadButton).click();
					break;
					
				default:
					throw new IllegalArgumentException("Invalid Button");
				}
				
			}
			
			public void UploadFile (String path) {
				driver.findElement(chooseFile).sendKeys(path);
			}

}
