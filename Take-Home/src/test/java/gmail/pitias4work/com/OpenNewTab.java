package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.library.pitias.Base;

public class OpenNewTab extends Base {
	Logger logger = Logger.getLogger(Base.class);

	public void newTab() {

		try {
			driver.get(prop.readProperties("newTab_url"));
			logger.info("Title is :" + driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			// Test clicks on the Click Here link.

			WebElement clickHere = driver.findElement(By.xpath(prop.readProperties("clickHere")));
			clickHere.click();

			driver = lib.switchWindows();

			WebElement text = driver.findElement(By.xpath(prop.readProperties("textField")));
			logger.info(text.getText());
			assertEquals(text.getText(), "New Window");
			test.log(Status.INFO, "New Window Assertion Success!!");

			lib.customWait(3);

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}
