package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseClass;

public class JSAlerts extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateJsAlerts() throws InterruptedException {
		// locate and click on JS alerts link
		WebElement alerts_link = driver.findElement(By.xpath("//a[contains(text(),'JavaScript Alerts')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(alerts_link));
		alerts_link.click();

		// verify if alerts page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/javascript_alerts";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		// click,assert and accept JS Alert
		WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
		jsAlert.click();
		Alert alert1 = driver.switchTo().alert();
		String alrtMsg1 = alert1.getText();
		System.out.println(alrtMsg1);
		String exp_alrtMsg1 = "I am a JS Alert";
		softassert.assertEquals(alrtMsg1, exp_alrtMsg1);
		alert1.accept();

		// click,assert and accept JS confirm
		WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
		jsConfirm.click();
		Thread.sleep(1000);
		Alert alert2 = driver.switchTo().alert();
		String alrtMsg2 = alert2.getText();
		System.out.println(alrtMsg2);
		String exp_alrtMsg2 = "I am a JS Confirm";
		softassert.assertEquals(alrtMsg2, exp_alrtMsg2);
		alert2.accept();

		// click,send message to alert,verify and accept JS prompt
		WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
		jsPrompt.click();
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Just testing");
		Thread.sleep(1000);
		alert3.accept();
		WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
		String act_txt = result.getText();
		String exp_txt = "You entered: Just testing";
		System.out.println(act_txt);
		softassert.assertEquals(act_txt, exp_txt);

		softassert.assertAll();

	}

}
