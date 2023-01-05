package java.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {
	
	WebDriver driver;
	
	public FileUploadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@id='file-upload']")
	WebElement fileUpload;
	
	
	
	
	
	
	public void uploadingFile() throws IOException
	{
		
		
		fileUpload.click();
		
		//Using AUTO IT
		Runtime.getRuntime().exec("C:\\Users\\Home\\Downloads\\some-file.txt");
		WebElement upload = driver.findElement(By.xpath("//input[@id='file-submit']"));            //Upload button
		upload.click();
		   
	    System.out.println("file uploaded succesfully");
	
	
//	    fileUpload.sendKeys("C:\\Users\\Home\\Downloads\\some-file.txt");
//	    fileUpload.submit();
	
	
	}
	
	
	
	
	
	
	
	
	

}
