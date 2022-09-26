package testCases;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class DynamicLoading extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateDynamicLoading() throws InterruptedException {
		// locate and click on dynamic loading link
		WebElement dynamicLdng_link = driver.findElement(By.xpath("//a[contains(text(),'Dynamic Loading')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(dynamicLdng_link));
		dynamicLdng_link.click();

		// verify if dynamic loading page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/dynamic_loading";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		// locate and click on example 1 link
		WebElement exmpl1_link = driver
				.findElement(By.xpath("//a[contains(text(),'Example 1: Element on page that is hidden')]"));
		exmpl1_link.click();
		// locate and click on example 1 link
		WebElement start_btn = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
		start_btn.click();
		Thread.sleep(3000);
		// verifies element visible
		try {
			// Explicit wait condition for visibility of element
			WebDriverWait w = new WebDriverWait(driver, 5);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
			System.out.println("Element is visible");
			softassert.assertTrue(true);
		} catch (NoSuchElementException n) {
			System.out.println("Element is invisible");
			softassert.assertTrue(false);
		}

		softassert.assertAll();

	}

}
