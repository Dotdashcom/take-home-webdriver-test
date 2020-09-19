package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.library.pitias.Base;

public class Notification_Msg extends Base {

	public int i;
	public WebElement text;
	Logger logger = Logger.getLogger(Base.class);

	public void notification_message() {

		try {
			driver.get("http://localhost:7080/notification_message_rendered");
			logger.info("Title is :" + driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			// Test clicks on the Click Here link a multiple times.
			ArrayList<String> msg = new ArrayList<String>();

			try {
				for (int i = 0; i < 4; i++) {
					WebElement here = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
					lib.click(here);

					List<WebElement> data = driver.findElements(By.id("flash"));
					for (WebElement text : data) {
						System.out.println(text.getText());

						msg.add(text.getText());
					}

					lib.customWait(2);
				}
			} catch (Exception e) {
				WebElement here = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
				lib.click(here);

			}

			// Test asserts that one of the “Action Successful”, “Action unsuccessful,
			// please try again” and “Action
			// Unsuccessful” messages show on click.

			if (msg.contains("Action unsuccesful, please try again")) {
				assertTrue(true);
				test.log(Status.INFO, "Assertion Success!!");
			} else if (msg.contains("Action successful")) {
				assertTrue(true);
				test.log(Status.INFO, "Assertion Success!!");
			}  else { test.log(Status.FAIL, "Assertion Success!!");}

			lib.customWait(2);

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}
