package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Context extends base {
	@Test
	public void ContextTest() {
		driver.get(URL + "context_menu ");
		Actions action = new Actions(driver);
		WebElement ContextBox = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		action.contextClick(ContextBox).perform();
		String alertMessage = driver.switchTo().alert().getText();
		assertTrue(alertMessage.contains("You selected a context menu"));
		driver.switchTo().alert().accept();
		driver.close();
	}

}
