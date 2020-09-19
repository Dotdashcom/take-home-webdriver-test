package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;

public class CheckBox extends Base {
	Logger logger = Logger.getLogger(Base.class);

	public void box() {

		try {
			driver.get("http://localhost:7080/checkboxes");
			logger.info("Title is :" + driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			WebElement checkbox1 = driver.findElement(By.xpath("//body//input[1]"));
			WebElement checkbox2 = driver.findElement(By.xpath("//body//input[2]"));

			if (checkbox1.isSelected()) {
				logger.info("The checkbox 1 is selected");
			} else {
				lib.click(checkbox1);
				logger.info("The checkbox 1 is clicked");
			}

			if (checkbox2.isSelected()) {
				logger.info("The checkbox 2 is selected");
			} else {
				lib.click(checkbox2);
				logger.info("The checkbox 2 is clicked");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.error(e.getMessage());
		}
	}
}
