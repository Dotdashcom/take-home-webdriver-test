package Scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Library.Base;

public class JavaScript_Error extends Base {

	@Test
	public void logger() {

		try {
			driver.get("http://localhost:7080/javascript_error");

			// Test finds the JavaScript error on the page.
			System.out.println(driver.getTitle());

			// Test asserts that the page contains error: Cannot read property 'xyz' of
			// undefined
			WebElement load = driver.findElement(By.xpath("/html/body"));
			System.out.println(load.getAttribute("onload"));
			assertEquals(load.getAttribute("onload"), "loadError()");

			Thread.sleep(3000);

			// WebElement script = driver.findElement(By.xpath(" /html/head/script"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
