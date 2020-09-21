package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import utilities.DriverUtility;

public class FileDownload extends Base{
	
	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/download");
	}

	
	
	
//	Test clicks on the file.
//	Test asserts that the file is downloaded.
	
	@Test 
	public void fileDownload() throws InterruptedException {
		
		WebElement downloadPath= driver.findElement(By.linkText("some-file.txt")); 
		DriverUtility.clickonElement(downloadPath);
		DriverUtility.wait(2000);
	   
	    
	   
		
		
	}

}
