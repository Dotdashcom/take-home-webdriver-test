package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileDownloadPO {

	WebDriver driver;
	public FileDownloadPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void fileDownload()
	{
		WebElement downloadFile= driver.findElement(By.xpath("//a[normalize-space()='some-file.txt']"));
		downloadFile.click();
		
	}
	}
	
	


