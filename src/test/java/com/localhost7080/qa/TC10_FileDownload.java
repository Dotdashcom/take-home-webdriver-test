package com.localhost7080.qa;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;

public class TC10_FileDownload {

	WebDriver driver;
	Base_DDM base;
	
	//Method to get the path, and compare with the name of the file
	public static boolean verifyFile(String downloadPath, String fileName) {
		File path = new File(downloadPath);
		File[] pathContents = path.listFiles();
		
		//If the name are in the array of files, then return true and delete the file, else return false.
		for (int i = 0; i < pathContents.length; i++) {
			if (pathContents[i].getName().equals(fileName)) {
				pathContents[i].delete();
				return true;
			}
		}
		return false;
	}

	@BeforeTest
	public void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
	}

	@Test
	public void TC10_FileDownload_Script() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://localhost:7080/download");

		// Click on the link to download the file and get it name
		String name = driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]")).getText();
		driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]")).click();
		Thread.sleep(2000);
		// Verify if the name of the file is located in the download path
		Assert.assertEquals(verifyFile("C:/Users/JM00895463/Downloads", name), true);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
