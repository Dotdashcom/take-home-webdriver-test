package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.library.pitias.Base;

public class MouseHover extends Base {

	Logger logger = Logger.getLogger(Base.class);

	public void mouse() {

		try {
			driver.get("http://localhost:7080/hovers");
			logger.info("Title is :" + driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

//			Test does a mouse hover on each image.
//			Test asserts that additional information is displayed for each image.
			WebElement user1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
			WebElement user2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
			WebElement user3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));

			lib.moveToElement(user1);
			WebElement user1info = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
			logger.info(user1info.getText());
			assertEquals(user1info.getText(), "name: user1");
			test.log(Status.INFO, "name: user1 Assertion Success!!");
			lib.customWait(1);

			lib.moveToElement(user2);
			WebElement user2info = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
			logger.info(user2info.getText());
			assertEquals(user2info.getText(), "name: user2");
			test.log(Status.INFO, "name: user2 Assertion Success!!");
			lib.customWait(1);

			lib.moveToElement(user3);
			WebElement user3info = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
			logger.info(user3info.getText());
			assertEquals(user3info.getText(), "name: user3");
			test.log(Status.INFO, "name: user3 Assertion Success!!");

			lib.customWait(1);

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}
