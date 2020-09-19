package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;

public class OpenNewTab extends Base {
	Logger logger = Logger.getLogger(Base.class);

	public void newTab() {

		try {
			driver.get("http://localhost:7080/windows");
			logger.info("Title is :" + driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			// Test clicks on the Click Here link.

			String parent = driver.getWindowHandle();
			WebElement clickHere = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
			clickHere.click();

			// Test asserts that a new tab is opened with text New Window.

//			for (String child : driver.getWindowHandles()) {
//				driver.switchTo().window(child);
//			}

			driver = lib.switchWindows();

			WebElement text = driver.findElement(By.xpath("/html/body/div/h3"));
			logger.info(text.getText());
			assertEquals(text.getText(), "New Window");

			lib.customWait(3);

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}
