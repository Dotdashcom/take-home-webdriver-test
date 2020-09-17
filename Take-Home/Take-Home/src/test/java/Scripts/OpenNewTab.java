package Scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Library.Base;

public class OpenNewTab extends Base {

	@Test
	public void logger() {

		try {
			driver.get("http://localhost:7080/windows");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			// Test clicks on the Click Here link.
			String parent = driver.getWindowHandle();
			WebElement clickHere = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
			clickHere.click();

			// Test asserts that a new tab is opened with text New Window.

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}

			WebElement text = driver.findElement(By.xpath("/html/body/div/h3"));
			System.out.println(text.getText());
			assertEquals(text.getText(), "New Window");

			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
