package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FileUploadPO {

	WebDriver driver;
	public FileUploadPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void fileUpload() throws InterruptedException
	{
		WebElement uploadFile= driver.findElement(By.id("file-upload"));
		Thread.sleep(5000);
		uploadFile.sendKeys("C:\\Users\\Khushbu\\Downloads\\some-file (1).txt");
		Thread.sleep(5000);
		WebElement submit= driver.findElement(By.id("file-submit"));
		submit.click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//div//h3")).getText(), "File Uploaded!");
		
	}
	
	}
	
	


