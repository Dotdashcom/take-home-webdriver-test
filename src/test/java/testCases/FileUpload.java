package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class FileUpload extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateFileUpload() throws InterruptedException {
		// locate and click on file upload link
		WebElement fileUpload_link = driver.findElement(By.xpath("//a[contains(text(),'File Upload')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(fileUpload_link));
		fileUpload_link.click();

		// verify if file upload page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/upload";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		// locate and upload file
		WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
		chooseFile.sendKeys(
				"C:\\Users\\Ashni\\eclipse-workspace\\com.test\\src\\test\\resources\\uploadDocs\\some-file.txt");
		Thread.sleep(1000);
		WebElement uploadBtn = driver.findElement(By.xpath("//input[@id='file-submit']"));
		uploadBtn.click();
		Thread.sleep(1000);
		// verify file uploaded
		WebElement fileUploadedMsg = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]"));
		String successMsg = fileUploadedMsg.getText();
		String exp_successMsg = "File Uploaded!";
		softassert.assertEquals(successMsg, exp_successMsg);

		softassert.assertAll();

	}

}
