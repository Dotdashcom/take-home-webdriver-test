package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.library.pitias.Base;

public class DropDown extends Base {
	Logger logger = Logger.getLogger(Base.class);

	public void dropDown() {

		try {
			driver.get("http://localhost:7080/dropdown");
			logger.info("Verify Title :" + driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			WebElement dropdown = driver.findElement(By.cssSelector("#dropdown"));
			lib.dropDown(dropdown, 1);

			// Assertion Method
			String selectedText = lib.readDropDown(dropdown);
			assertEquals(selectedText, "Option 1");
			test.log(Status.INFO, "Assert Success!!");

			lib.customWait(2);

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}
