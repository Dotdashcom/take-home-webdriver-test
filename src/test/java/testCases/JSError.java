package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class JSError extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateJsError() throws InterruptedException {
		// locate and click on JS error link
		WebElement jsError_link = driver.findElement(By.xpath("//a[contains(text(),'JavaScript onload event error')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(jsError_link));
		jsError_link.click();

		// verify if JS error page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/javascript_error";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		// validate error message on page load
		WebElement error = driver.findElement(By.xpath("//body//p"));
		String error_msg = error.getText();
		String exp_errMsg = "This page has a JavaScript error in the onload event. "
				+ "This is often a problem to using normal Javascript injection techniques.";
		System.out.println(error_msg);
		softassert.assertEquals(error_msg, exp_errMsg);

		softassert.assertAll();

	}

}
