

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicContent {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_content");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void check() {
		WebElement content = driver.findElement(By.id("content"));
		List<WebElement> previousRow = content.findElements(By.className("row"));

		driver.navigate().refresh();
		content = driver.findElement(By.id("content"));
		List<WebElement> row = content.findElements(By.className("row"));

		for (int x = 0; x < previousRow.size(); x++) {
			assert !previousRow.get(x).equals(row.get(x));
		}

	}

}
