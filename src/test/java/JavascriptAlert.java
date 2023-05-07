

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptAlert {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get(" http://localhost:7080/javascript_alerts ");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void alert() {

		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		for (WebElement button : buttons) {
			if (button.getText().contains("Alert")) {
				alertTest(button);
			} else if (button.getText().contains("Confirm")) {
				confirmTest(button);
			} else if (button.getText().contains("Prompt")) {
				promptTest(button);
			}
		}
	}

	public void alertTest(WebElement e) {
		e.click();

		driver.switchTo().alert().accept();
		assert driver.findElement(By.id("result")).getText().contains("You successfuly clicked an alert");

	}

	public void confirmTest(WebElement e) {
		e.click();

		driver.switchTo().alert().accept();
		assert driver.findElement(By.id("result")).getText().contains("You clicked: Ok");
	}

	public void promptTest(WebElement e) {
		e.click();
		driver.switchTo().alert().sendKeys("testing...");
		driver.switchTo().alert().accept();
		assert driver.findElement(By.id("result")).getText().contains("You entered: testing...");

	}

}
