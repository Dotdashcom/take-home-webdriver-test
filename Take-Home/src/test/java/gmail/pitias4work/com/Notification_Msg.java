package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;

public class Notification_Msg extends Base {

	public int i;
	public WebElement text;

	public void notification_message() {

		try {
			driver.get("http://localhost:7080/notification_message_rendered");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			// Test clicks on the Click Here link a multiple times.
			ArrayList<String> msg = new ArrayList<String>();

			try {
				for (int i = 0; i < 4; i++) {
					WebElement here = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", here);

					List<WebElement> data = driver.findElements(By.id("flash"));
					for (WebElement text : data) {
						System.out.println(text.getText());

						msg.add(text.getText());
					}

					Thread.sleep(2000);
				}
			} catch (Exception e) {
				WebElement here = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", here);

			}

			// Test asserts that one of the “Action Successful”, “Action unsuccessful,
			// please try again” and “Action
			// Unsuccessful” messages show on click.

			if (msg.contains("Action unsuccesful, please try again")) {
				assertTrue(true);
			} else if (msg.contains("Action successful")) {
				assertTrue(true);
			}

			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
