package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.library.pitias.Base;

public class JavaScript_Error extends Base {

	public void jse() {
		String error = null;

		try {
			driver.get("http://localhost:7080/javascript_error");

			LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
			// Test finds the JavaScript error on the page.

			for (LogEntry entry : logEntries) {
				System.out.println("JavaScript Error :" + entry.getLevel() + " " + entry.getMessage() + "\n");

				error = entry.getMessage();
			}

			// Test asserts that the page contains error: Cannot read property 'xyz' of
			// undefined

			System.out.println("Page Error :" + error.substring(64));
			assertEquals(error.substring(64), "Cannot read property 'xyz' of undefined");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
