

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotificationMessage {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get("   http://localhost:7080/notification_message_rendered");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void notification() {
		Set<String> type = new HashSet<String>();
		while (type.size() < 2) {		
			WebElement button = driver.findElement(By.id("content")).findElement(By.tagName("a"));
			button.click();
			WebElement notificationArea = driver.findElement(By.id("flash"));
			String msg = notificationArea.getText();
			type.add(msg);
			assert msg.contains("Action unsuccesful, please try again")
					|| msg.contains("Action successful");

		}

	}

}
