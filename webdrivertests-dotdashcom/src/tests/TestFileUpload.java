/**
 * 
 */
package tests;

import org.openqa.selenium.By;

/**
 * @author connorparnell
 *
 */
     
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.time.Duration;


public class TestFileUpload {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/upload");
		
	}
	
	@Test
	public void fileUploadSuccess() {
		// upload testfile.txt
		String dir = System.getProperty("user.dir");
		WebElement chooseFile = driver.findElement(By.xpath("//*[@id='file-upload']"));
		chooseFile.sendKeys(dir + "/src/testfile.txt");
		WebElement uploadButton = driver.findElement(By.xpath("//*[@id=\'file-submit\']"));
		uploadButton.click();
		// wait until file is uploaded and then assert that it is
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='uploaded-files']")));
		assertTrue(true); // wait.until() will cause failure if not success 
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}