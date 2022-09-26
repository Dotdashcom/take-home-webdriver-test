package testCases;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class FileDownload extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void isFileDownloaded() throws InterruptedException {
		// locate and click on file download link
		WebElement fileDwnld_link = driver.findElement(By.linkText("File Download"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(fileDwnld_link));
		fileDwnld_link.click();

		// verify if file downloade page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/download";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		// locate and click download link
		WebElement dwnldLink = driver.findElement(By.xpath("//a[contains(text(),'some-file.txt')]"));
		dwnldLink.click();
		Thread.sleep(2000);

		File fileLocation = new File("C:\\Users\\Ashni\\Downloads"); // traversing to file location
		File[] totalFiles = fileLocation.listFiles(); // getting all files from the download location

		// iterating to the expected downloaded file
		for (File file : totalFiles) {
			if (file.getName().equals("some-file.txt")) {
				System.out.println("File is downloaded");
				softassert.assertTrue(true, "File is downloaded");
				break;
			}
		}
		softassert.assertAll();

	}

}
