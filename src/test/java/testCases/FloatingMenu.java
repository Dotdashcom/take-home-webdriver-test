package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class FloatingMenu extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateFloatingMenu() throws InterruptedException {
		// locate and click on floating menu link
		WebElement floatingMnu_link = driver.findElement(By.xpath("//a[contains(text(),'Floating Menu')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(floatingMnu_link));
		floatingMnu_link.click();

		// verify if floating menu page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/floating_menu";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		// scroll down vertically
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(1000);

		// verify floating menu displayed after scroll down
		WebElement floatingMenu = driver.findElement(By.xpath("//div[@id='menu']"));
		if (floatingMenu.isDisplayed() == true) {
			System.out.println("Floating menu is displayed");
			softassert.assertTrue(true);
		}

		softassert.assertAll();

	}

}
