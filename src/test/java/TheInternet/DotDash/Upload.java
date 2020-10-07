package TheInternet.DotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Upload extends base {
	
	@Test
	public void UploadTest() throws InterruptedException {
		driver.get(URL + "upload ");
		WebElement upload = driver.findElement(By.xpath("//input[@id='file-upload']"));
		upload.sendKeys(System.getProperty("user.dir") + "/src/some-file.txt");
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		String Text = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		Assert.assertEquals("File Uploaded!", Text);
	}

}
