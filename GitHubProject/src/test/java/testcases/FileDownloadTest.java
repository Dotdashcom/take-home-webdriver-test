package testcases;

import org.testng.annotations.Test;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileDownloadTest extends BaseTestMethods {
	
  @Test
  public void Test() throws InterruptedException {
	  
	  
	  
	  driver.get("http://localhost:7080/download");
	  WebElement link=driver.findElement(By.xpath("//a[normalize-space()='some-file.txt']"));
	  link.click();
	  Thread.sleep(2000);
	  String path="C:\\Users\\onero\\Downloads";
	  String filename="some-file.txt";
	  File dir = new File(path);
	  File[] dirContents = dir.listFiles();
	   
	  for (int i = 0; i < dirContents.length; i++) {
	      if (dirContents[i].getName().equals(filename)) {
	    	  System.out.println("file found");
	      }
	     
	  }
	          
	  }}
	  
	  
	  
 
		  
		  
		  
		  
	  
	
	 
	 
	  
	  
	  
	  
	
