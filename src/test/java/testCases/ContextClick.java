package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseClass;

public class ContextClick extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateContextClick() throws InterruptedException {
		// locate and click on context menu link
		WebElement cnxtMnu_link = driver.findElement(By.xpath("//a[contains(text(),'Context Menu')]"));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(cnxtMnu_link));
		cnxtMnu_link.click();

		// verify if context menu page is open
		String act_url = driver.getCurrentUrl();
		String exp_url = "http://localhost:7080/context_menu";
		System.out.println(act_url);
		if (act_url.equals(exp_url)) {
			softassert.assertTrue(true);
		}

		WebElement box = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		Actions act = new Actions(driver);
		act.contextClick(box).build().perform(); // perform right click
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert(); // switch to alert

		String act_alertMessage = driver.switchTo().alert().getText(); // capture alert message
		String exp_alertMessage = "You selected a context menu";
		System.out.println(act_alertMessage); // Print Alert Message

		// verify alert pops up
		softassert.assertEquals(act_alertMessage, exp_alertMessage);

		alert.accept();
		Thread.sleep(1000);

		softassert.assertAll();
	}

}
