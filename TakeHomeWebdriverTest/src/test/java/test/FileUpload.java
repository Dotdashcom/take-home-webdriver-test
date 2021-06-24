package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class FileUpload extends TestBase {
	@BeforeTest
	public void beforeFileUploadTest() {
		setup();
		driver.get("http://localhost:7080/upload");
	}

	@AfterTest
	public void afterFileUploadTest() {
		teardown();
	}
	
	@Test
	public void fileUploadTest() {
		//driver.findElement(By.xpath("//a[contains(text(),'File Upload')]")).click();
		WebElement uploadInput = driver.findElement(By.id("file-upload"));
		uploadInput.sendKeys("C:\\Users\\abdul\\Desktop\\test.txt");
		driver.findElement(By.id("file-submit")).click();
		WebElement uploadedFilesInfo = driver.findElement(By.id("uploaded-files"));
		Assert.assertEquals(uploadedFilesInfo.getText(), "test.txt");
		
	}
}
