package staffitsolution.qa.wlctointernet.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class FileUploadTest extends BaseTest{

	@Test
	public void fileUploadTest() throws InterruptedException
	{
		driver.get(prop.getProperty("fileUploadurl"));
		Thread.sleep(2000);
		WebElement fileupld= driver.findElement(By.xpath("//input[@id='file-upload']"));
		fileupld.sendKeys("C:\\Users\\harsha\\Downloads\\some-file.txt");
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		System.out.println("File Uploaded successfully");
		
		String Fileuploadedtext=driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText();
        Assert.assertEquals(Fileuploadedtext, "some-file.txt");
}
}
	
