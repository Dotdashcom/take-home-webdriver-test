package testcases;

import org.testng.annotations.Test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FileUploadTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/upload");
	  WebElement chooseFilebtn= driver.findElement(By.id("file-upload"));
	  WebElement uploadbtn = driver.findElement(By.id("file-submit"));
	  chooseFilebtn.sendKeys("C:\\Users\\onero\\Downloads\\some-file.txt");
	 
	  uploadbtn.click();
	  Thread.sleep(2000);
	  boolean value =(driver.getPageSource().contains("File Uploaded!"));
	  Assert.assertEquals(value, true);

	  
	  }
	         
	  }
	  
	  
	  
 
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
