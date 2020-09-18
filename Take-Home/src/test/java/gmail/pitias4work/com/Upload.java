package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;

public class Upload extends Base {

	public void upload() {

		try {
			driver.get("http://localhost:7080/upload");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			// Test uses Upload Button or Drag and Drop to upload a file.
			WebElement upload = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", upload);

			Thread.sleep(2000);
			upload.sendKeys("/Users/pitiasfessahaie/Downloads/some-file.txt");

			WebElement submit = driver.findElement(By.cssSelector("#file-submit"));
			submit.click();

			// Assertion upload

			if (driver.findElement(By.cssSelector("#uploaded-files")).isDisplayed()) {
				assertTrue(true, "The File is uploaded sucessfully");
			} else {
				assertTrue(false, "The File did not uploaded ");
			}

			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
