package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.library.pitias.Base;

public class JavaAlert extends Base {
	Logger logger = Logger.getLogger(Base.class);

	public void alert() {

		try {

			driver.get("http://localhost:7080/javascript_alerts");
			logger.info("Title is :" + driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			// Test Clicks on JS Alert Button.
			WebElement alertbtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
			alertbtn.click();
			// Test asserts alert message.
			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), "I am a JS Alert");
			test.log(Status.INFO, "Alert Assertion Success!!");
			alert.accept();
			lib.customWait(2);

			// Test clicks on JS confirm Button and clicks ok on alert.

			WebElement jsconfirmbtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
			lib.hiddenClick(jsconfirmbtn);
			String confirm = alert.getText();
			alert.accept();

			lib.customWait(3);

			// Test asserts the alert message.
			assertEquals(confirm, "I am a JS Confirm");
			test.log(Status.INFO, "Confirm Assertion Success!!");

//			Test clicks on JS Prompt Button and types a message on Prompt.
			WebElement prompt = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
			prompt.click();
			alert.sendKeys("I Love USA !!!");

			lib.customWait(2);
			alert.accept();

//			Test asserts that the alert message contains the typed message.
			WebElement result = driver.findElement(By.cssSelector("#result"));
			String msg = result.getText().substring(13);
			logger.info("Message is :" + result.getText().substring(13));
			lib.customWait(1);

//		Test asserts that the alert message contains the typed message.
			assertEquals(msg, "I Love USA !!!");
			test.log(Status.INFO, "Message Assertion Success!!");

		} catch (Exception e) {
			logger.error(e.getMessage());
			test.error(e.getMessage());
		}

	}
}
