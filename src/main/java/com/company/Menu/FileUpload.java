package com.company.Menu;

import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload {

	@Test
	public void FileUploadTest() throws Exception
	{
		BrowseFactory.setUp();
		
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.file_UploadPageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		baseObjectClass.filen().sendKeys("C:\\Users\\16475\\Desktop\\sample.txt");
		
		baseObjectClass.upload().click();
		
		WebElement txt=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
		Assert.assertTrue(txt.getText().contains("File Uploaded!"));
		Thread.sleep(5000);
		
		BrowseFactory.tearDown();
		
	}
	
}
