package gmail.pitias4work.com;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.library.pitias.Base;

public class JavaAlert extends Base {

	public void alert() {

		try {
			driver.get("http://localhost:7080/javascript_alerts");
			System.out.println(driver.getTitle());
			assertEquals(driver.getTitle(), "The Internet");

			// Test Clicks on JS Alert Button.
			WebElement alertbtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
			alertbtn.click();
			// Test asserts alert message.
			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), "I am a JS Alert");
			alert.accept();
			Thread.sleep(2000);

			// Test clicks on JS confirm Button and clicks ok on alert.

			WebElement jsconfirmbtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", jsconfirmbtn);
			Thread.sleep(2000);
			String confirm = alert.getText();
			alert.accept();

			Thread.sleep(3000);

			// Test asserts the alert message.
			assertEquals(confirm, "I am a JS Confirm");

//			Test clicks on JS Prompt Button and types a message on Prompt.
			WebElement prompt = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
			prompt.click();
			alert.sendKeys("I Love RTR !!!");

			Thread.sleep(2000);
			alert.accept();

//			Test asserts that the alert message contains the typed message.
			WebElement result = driver.findElement(By.cssSelector("#result"));
			String msg = result.getText().substring(13);
			System.out.println(result.getText().substring(13));
			Thread.sleep(3000);

//		Test asserts that the alert message contains the typed message.
			assertEquals(msg, "I Love RTR !!!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
