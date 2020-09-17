package Scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Library.Base;

public class dynamicControls extends Base {

	WebElement checkbox;

	@Test
	public void logger() {

		try {
			driver.get("http://localhost:7080/dynamic_controls");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");
			// Test clicks on the Remove Button and uses explicit wait.

			WebElement remove = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			remove.click();

			WebElement elect = driver.findElement(By.cssSelector("#message"));
			wait.until(ExpectedConditions.visibilityOf(elect));
			Thread.sleep(3000);

			// Test asserts that the Check box is gone.
			try {
				checkbox = driver.findElement(By.cssSelector("#checkbox"));
				assertTrue(!checkbox.isEnabled());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
//			// Test clicks on Add Button and uses explicit wait

			WebElement button = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
			button.click();

			WebElement msg = driver.findElement(By.cssSelector("#message"));
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			wait2.until(ExpectedConditions.visibilityOf(msg));
//
//			// Test asserts that the Check box is present.
			assertTrue(checkbox.isDisplayed());

			// Test clicks on the Enable Button and uses explicit wait.
			WebElement enable = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
			enable.click();
			wait2.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/*[@id=\"input-example\"]/input"))));

			// Test asserts that the text box is enabled.
			WebElement text = driver.findElement(By.xpath("/*[@id=\"input-example\"]/input"));
			assertTrue(text.isEnabled());

			// Test asserts that the text box is disabled.
			WebElement disable = driver.findElement(By.cssSelector("#input-example > button"));

			// disable.click(); ??????
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", disable);

			Thread.sleep(2000);
			assertTrue(!text.isEnabled());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
