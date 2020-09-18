package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;

public class FloatingMenu extends Base {

	public void Floater() {

		try {
			driver.get("http://localhost:7080/floating_menu");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			// Test scrolls the page.

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0,2000 )");

			// Test asserts that the floating menu is still displayed.
			WebElement scroll = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a"));
			assertTrue(scroll.isDisplayed());

			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
