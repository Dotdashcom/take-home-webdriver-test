

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/context_menu");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void rightClickAlertTest() {
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.id("hot-spot"))).perform();
		assert driver.switchTo().alert().getText() != null
				&& driver.switchTo().alert().getText().contains("You selected a context menu");
		driver.switchTo().alert().dismiss();

	}

}
