package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.library.pitias.Base;

public class FloatingMenu extends Base {

	Logger logger = Logger.getLogger(Base.class);

	public void Floater() {

		try {
			driver.get(prop.readProperties("floating_url"));
			logger.info("Title is :" + driver.getTitle());

			assertEquals(driver.getTitle(), "The Internet");

			// Test scrolls the page.

			lib.scrollDown(2000);

			// Test asserts that the floating menu is still displayed.
			WebElement scroll = driver.findElement(By.xpath(prop.readProperties("scroll")));
			assertTrue(scroll.isDisplayed());
			test.log(Status.INFO, "Scroll is Displayed Assert Success!!");

			lib.customWait(2);

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}
