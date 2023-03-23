package shakilTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest_4 extends TestBase {
	
	@Test
	public void contextMenuTest() {
		Actions actions = new Actions(driver);

		driver.get("http://localhost:7080/context_menu");
		
		// Find the context menu box using its ID
		WebElement contextMenuBox = driver.findElement(By.id("hot-spot"));
		
		// Right-click on the context menu box using the Actions class
		actions.contextClick(contextMenuBox).build().perform();
		
		// Switch to the alert and get its text
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
		// Verify that the alert text is correct
		Assert.assertEquals(alertText, "You selected a context menu");
		
		// Accept the alert
		alert.accept();
	}
}
