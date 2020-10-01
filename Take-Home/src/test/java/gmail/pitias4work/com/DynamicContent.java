package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.library.pitias.Base;

public class DynamicContent extends Base {
	Logger logger = Logger.getLogger(Base.class);

	
	public void dynamic_Content() {

		try {
			driver.get(prop.readProperties("dynamic_url"));
			logger.info("Title is :" + driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			String locate = prop.readProperties("locate");

			for (int i = 0; i <= 3; i++) {
				driver.navigate().refresh();
				lib.customWait(2);

				List<WebElement> images = driver.findElements(By.xpath(locate));

				String imageFileName = prop.readProperties("avatar6");
				for (WebElement image : images) {
					if (image.getAttribute("src").contains(imageFileName)) {
						assertTrue(false);
						test.log(Status.FAIL, "Assertion Fail!!");
					}
				}
				lib.customWait(3);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}
