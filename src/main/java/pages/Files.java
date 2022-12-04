package pages;



import java.io.File;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

import mainUtils.UtilityClass;

public class Files {
	WebDriver driver;
	public String downloadPath = System.getProperty("user.dir") + "\\test";
	
	By txt_filedownload =By.xpath("//*[@id=\"content\"]/div/h3");
	By lnk_dwnlod_file =By.linkText("some-file.txt");
	
	By chooseFile = By.id("file-upload");
	By btn_file_submit= By.id("file-submit");
	
	By txt_file_submitted= By.id("uploaded-files");
	
	 public Files(WebDriver driver){

	    	this.driver = driver;

	    }
	 UtilityClass utlity = new UtilityClass(driver);
	 
	 public void file_Download(String toptext) throws InterruptedException {
		 
	    	
		 	Reporter.log("Inside File Download Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	    	utlity.validate_Text(txt_filedownload,toptext,driver);
	    	
	    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	
	    	System.out.println("Deleting files now");
	    	String delet_path = downloadPath+"\\some-file.txt";
	    	utlity.delete_files(delet_path);
	    	
	    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	
	    	Reporter.log("Downloading file now");
	    	WebElement link_download_file = driver.findElement(lnk_dwnlod_file);
	    	String dwnld_filename=link_download_file.getText();
	    	link_download_file.click();
	    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	
	    	Thread.sleep(10000);
	    	Reporter.log("File Downloaded now");
	    	
	    	System.out.println(dwnld_filename);
	    	
	    	boolean file_status = utlity.isFileDownloaded_Ext(downloadPath, dwnld_filename);
		    
		    Assert.assertTrue(file_status, "Downloaded file name is not matching with expected file name");
	    	
	    }
	 
	 public void file_Upload(String toptext) throws InterruptedException {
		 Reporter.log("Inside File upload Method $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	    	
		 
		 utlity.validate_Text(txt_filedownload,toptext,driver);

		 String path = downloadPath+"\\some-file.txt";
		 
		 utlity.enter_text(chooseFile, driver,path);
		 utlity.click_anything(btn_file_submit, driver);
		 utlity.validate_Text(txt_file_submitted,"some-file.txt",driver);
	 }
}
