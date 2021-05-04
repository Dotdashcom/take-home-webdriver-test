package com.arthi.pageobjects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arthi.automation.common.PageBase;


/**
 * 
 * @author Arthina
 *
 */
public class FileUploadPage extends PageBase {
	

	private static final String Base_URL = "http://localhost:7080/upload";
	
	@FindBy (id="file-upload")
	private WebElement chooseFileBtn;
	
	@FindBy (xpath="//*[@id='file-submit']")
	private WebElement uploadBtn;
	
	@FindBy (id="uploaded-files")
	private WebElement uploadedFilesnameLbl;
	
	@FindBy (xpath="//div[@class='example']//h3")
	private WebElement fileUploadedLbl;
	
	public FileUploadPage(WebDriver driver) {
		super(driver);
	}
	
	public FileUploadPage navigateToFileUploadPage() {
		driver.get(Base_URL);
		return this;
		
	}
	
	public FileUploadPage verifyUploadFile(final String filePath) {
		uploadFile(chooseFileBtn, filePath);
		submitForm(uploadBtn);
		return this;
	}
	
	public FileUploadPage verifyFileUploadedSuccessPage(String fileName){
		assertEquals(fileUploadedLbl, "File Uploaded!");
		assertContains(uploadedFilesnameLbl, fileName);
		return this;
	}
	

	

}
