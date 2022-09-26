package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class DynamicContent extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateDynamicContent() throws InterruptedException {
		// locate and click on dynamic content link
		WebElement dynmcCntnt_link = driver.findElement(By.xpath("//a[contains(text(),'Dynamic Content')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(dynmcCntnt_link));
		dynmcCntnt_link.click();

		// verify if dynamic content page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/dynamic_content";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		// loop to refresh the page multiple times
		for (int i = 0; i < 5; i++) {
			String beforeRefrsh_pageSource = driver.getPageSource(); // get pagesource before refresh
			driver.navigate().refresh();
			Thread.sleep(1000);
			String afterRefrsh_pageSource = driver.getPageSource(); // get page source after refresh
			softassert.assertFalse(afterRefrsh_pageSource.equals(beforeRefrsh_pageSource)); // verify page contents not
																							// same before and after
																							// refresh

		}

		softassert.assertAll();

	}

}
