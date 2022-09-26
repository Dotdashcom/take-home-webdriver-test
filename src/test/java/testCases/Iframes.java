package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class Iframes extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateIframe() throws InterruptedException {
		// locate and click on frames link
		WebElement frames_link = driver.findElement(By.linkText("Frames"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(frames_link));
		frames_link.click();

		// verify if frames page is open
		String act_url_frames = driver.getCurrentUrl();
		String exp_url_frames = "http://localhost:7080/frames";
		System.out.println(act_url_frames);
		if (act_url_frames.equals(exp_url_frames)) {
			softassert.assertTrue(true);
		}

		// locate and click on iframe link
		WebElement iFrame_link = driver.findElement(By.linkText("iFrame"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(iFrame_link));
		iFrame_link.click();

		// verify if iframe page is open
		String act_url_iframe = driver.getCurrentUrl();
		String exp_url_iframe = "http://localhost:7080/iframe";
		System.out.println(act_url_iframe);
		if (act_url_iframe.equals(exp_url_iframe)) {
			softassert.assertTrue(true);
		}

		driver.switchTo().frame(0);
		WebElement txtBox = driver.findElement(By.cssSelector("body.mce-content-body:nth-child(2) > p:nth-child(1)"));

		String act_txt = txtBox.getText();
		System.out.println(act_txt);
		String exp_txt = "Your content goes here.";
		softassert.assertEquals(act_txt, exp_txt);

		txtBox.clear();
		Thread.sleep(1000);
		txtBox.sendKeys("Just Testing");
		Thread.sleep(2000);

		softassert.assertAll();

	}

}
