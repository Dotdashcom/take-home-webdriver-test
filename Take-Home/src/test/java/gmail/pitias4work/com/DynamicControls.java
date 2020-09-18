package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;


public class DynamicControls extends Base {
	Logger logger = Logger.getLogger(Base.class);

	WebElement checkbox;

	public void dynamic_Control() {

		try {
			
			driver.get("http://localhost:7080/dynamic_controls");
			logger.info("Title is :"+driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");
			// Test clicks on the Remove Button and uses explicit wait.

			WebElement remove = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
			lib.click(remove);

			WebElement elect = driver.findElement(By.xpath("//p[@id='message']"));
			lib.explicitWait(elect);

			// Test asserts that the Check box is gone.

			checkbox = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/div[2]"));
			if (checkbox == null) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}

//			// Test clicks on Add Button and uses explicit wait

			WebElement button = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
			lib.click(button);

			WebElement msg = driver.findElement(By.cssSelector("#message"));
			lib.explicitWait(msg);
//
//			// Test asserts that the Check box is present.
			assertTrue(checkbox.isDisplayed());

			// Test clicks on the Enable Button and uses explicit wait.
			WebElement enable = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
			lib.click(enable);
			lib.explicitWait(driver.findElement(By.xpath("/*[@id=\"input-example\"]/input")));

			// Test asserts that the text box is enabled.
			WebElement text = driver.findElement(By.xpath("/*[@id=\"input-example\"]/input"));
			assertTrue(text.isEnabled());

			// Test asserts that the text box is disabled.
			WebElement disable = driver.findElement(By.cssSelector("#input-example > button"));

			// disable.click(); ??????
			lib.hiddenClick(disable);

			Thread.sleep(2000);
			assertTrue(!text.isEnabled());

		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.error(e.getMessage());
		}

	}
}
