package dotdashcom_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC04_ContextMenu extends BaseTest{


	// method to start browser which has browser config
	@BeforeMethod
	public void BrowserInvoking() {
		// getting url to the browser
		driver.get("http://localhost:7080/context_menu");

		
	}

	@Test
	public void context_right_click() {
		// webelement of context menu
		WebElement context_element = driver.findElement(By.id("hot-spot"));

		// boject is created for action class to access the actions events
		Actions move = new Actions(driver);

		// moved to context menu box and right clicked the menu
		move.contextClick(context_element).build().perform();

		// switched to alert abd received text present in the alert
		String alert_text = driver.switchTo().alert().getText();

		// printed alert text in console
		System.out.println("Alert Text is : " + alert_text);

		// alert is accepted
		driver.switchTo().alert().accept();

		// asserted the alert text is expected or not
		Assert.assertEquals(alert_text, "You selected a context menu");
		

	}

}
