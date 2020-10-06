package TheInternet.DotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Upload {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/upload");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void UploadTest() throws InterruptedException {

		WebElement upload = driver.findElement(By.xpath("//input[@id='file-upload']"));
		upload.sendKeys(System.getProperty("user.dir") + "/src/some-file.txt");
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		String Text = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		Assert.assertEquals("File Uploaded!", Text);
	}

}
