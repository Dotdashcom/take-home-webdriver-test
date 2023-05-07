

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenInNewTab {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get("   http://localhost:7080/windows");
	}

	@AfterEach
	public void close() {
		driver.getWindowHandles().forEach(handler -> driver.switchTo().window(handler).close());

	}

	@Test
	public void newTab() {
		assert driver.getWindowHandles().size() == 1;
		String wh = driver.getWindowHandle();
		driver.findElement(By.id("content")).findElement(By.tagName("a")).click();
		assert driver.getWindowHandles().size() == 2;
		for (String handler : driver.getWindowHandles()) {
			if (!wh.equals(handler)) {
				assert driver.switchTo().window(handler).findElement(By.tagName("body")).getText()
						.contains("New Window");

			}
		}

	}

}
