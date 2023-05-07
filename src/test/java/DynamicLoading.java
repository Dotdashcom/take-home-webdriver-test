

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoading {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_loading/2");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void load() {
		WebElement button = driver.findElement(By.id("start")).findElement(By.tagName("button"));
		Actions action = new Actions(driver);
		action.click(button).perform();

		
		new WebDriverWait(driver, Duration.ofMillis(5000))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));

		assert driver.findElement(By.id("finish")).getText().contains("Hello World!");

	}

}
