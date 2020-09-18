package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;

public class Iframe extends Base {

	public void frame() {

		try {
			driver.get("http://localhost:7080/iframe");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			// Test switches to Iframe and types some text.
			driver.switchTo().frame(0);
			WebElement sentence = driver.findElement(By.cssSelector("#tinymce"));
			sentence.sendKeys("I love RTR !!!");

			// Test asserts that the typed text is as expected.
			assertEquals(sentence.getText(), "Your content goes here.I love RTR !!!");

			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
