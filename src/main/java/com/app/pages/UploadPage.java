package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.util.PageLinks;

public class UploadPage extends BasePage{

	public UploadPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='file-upload']")
	private WebElement chooseFile;
	
	@FindBy(xpath = "//input[@id='file-submit']")
	private WebElement uploadFile;
	
	@FindBy(xpath = "//div[@id='content']//h3")
	private WebElement fileUploadedEl;
	
	public void visitUploadPage() {
		getDriver().get(PageLinks.FILE_UPLOAD_PAGE);
	}
	
	
	public void verifyUpload() {
		
		File fileToUpload = createNewFile();
		System.out.println(fileToUpload.getAbsolutePath().toString());
		chooseFile.sendKeys(fileToUpload.getAbsoluteFile().toString());
		uploadFile.click();
		assertEquals("File Uploaded!", fileUploadedEl.getText().trim());
	}
	
	private File createNewFile() {
		
		String file = "some_file_"+ new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date()) + ".txt";
		  try {
		      File myObj = new File(file);
		      if (myObj.createNewFile()) {
		    	  
		        return myObj;
		      } else {
		       return null;
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		return null;
	}
}
