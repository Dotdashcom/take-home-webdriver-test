package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;

public class Iframe extends Base {
	
	Logger logger = Logger.getLogger(Base.class);
 
	public void frame() {

		try {
			driver.get("http://localhost:7080/iframe");
			logger.info(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			// Test switches to Iframe and types some text.
			driver.switchTo().frame(0);
			WebElement sentence = driver.findElement(By.cssSelector("#tinymce"));
			sentence.sendKeys("I love RTR !!!");

			// Test asserts that the typed text is as expected.
			assertEquals(sentence.getText(), "Your content goes here.I love RTR !!!");

			lib.customWait(2);

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}
