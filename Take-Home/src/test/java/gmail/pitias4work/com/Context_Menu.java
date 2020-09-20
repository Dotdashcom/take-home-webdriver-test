package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.library.pitias.Base;

public class Context_Menu extends Base {

	Logger logger = Logger.getLogger(Base.class);
	String text = "You selected a context menu";

	public void context() {

		try {
			driver.get("http://localhost:7080/context_menu");

			assertEquals(driver.getTitle(), "The Internet");
			logger.info("Title Verified :" + driver.getTitle());

			WebElement rightclick = driver.findElement(By.cssSelector("#hot-spot"));
			lib.rightClick(rightclick);

			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), text);
			test.log(Status.INFO, "Assert Success!!");

			alert.accept();
			lib.customWait(2);

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());

		}
	}
}
