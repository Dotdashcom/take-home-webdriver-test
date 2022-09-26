package testCases;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class DynamicControls extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test(priority = 1)
	public void validateDynamicControls() throws InterruptedException {
		// locate and click on dynamic controls link
		WebElement dynmcCntrl_link = driver.findElement(By.xpath("//a[contains(text(),'Dynamic Controls')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(dynmcCntrl_link));
		dynmcCntrl_link.click();

		// verify if dynamic controls page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/dynamic_controls";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void validateRemoveChckBx() throws InterruptedException {

		WebElement rmButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		rmButton.click();
		Thread.sleep(3000);

		try {
			// Explicit wait condition for visibility of element
			WebDriverWait w = new WebDriverWait(driver, 5);
			w.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']/div/input")));
			System.out.println("Element is visible");
		} catch (NoSuchElementException n) {
			System.out.println("Element is invisible");
		}
		softassert.assertAll();

	}

	@Test(priority = 3)
	public void validateAddChckBx() throws InterruptedException {

		WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		addButton.click();
		Thread.sleep(3000);
		try {
			// Explicit wait condition for visibility of element
			WebDriverWait w = new WebDriverWait(driver, 5);
			w.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']/div/input")));
			System.out.println("Element is visible");
		} catch (NoSuchElementException n) {
			System.out.println("Element is invisible");
		}
		softassert.assertAll();

	}

	@Test(priority = 4)
	public void validateEnable() throws InterruptedException {

		WebElement enableBtn = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
		enableBtn.click();
		Thread.sleep(4000);
		try {
			// Explicit wait condition for visibility of element
			WebDriverWait w = new WebDriverWait(driver, 5);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='input-example']/input")));
			System.out.println("Element is visible");
		} catch (NoSuchElementException n) {
			System.out.println("Element is invisible");
		}
		softassert.assertAll();
	}

	@Test(priority = 5)
	public void validateDisable() throws InterruptedException {

		WebElement disableBtn = driver.findElement(By.xpath("//button[contains(text(),'Disable')]"));
		disableBtn.click();
		Thread.sleep(4000);
		try {
			// Explicit wait condition for visibility of element
			WebDriverWait w = new WebDriverWait(driver, 5);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='input-example']/input")));
			System.out.println("Element is visible");
		} catch (NoSuchElementException n) {
			System.out.println("Element is invisible");
		}
		softassert.assertAll();
	}

}
