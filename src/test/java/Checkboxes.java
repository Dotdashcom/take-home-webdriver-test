

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/checkboxes");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void checkAll() {
		WebElement checkbox = driver.findElement(By.id("checkboxes"));
		List<WebElement> boxes = checkbox.findElements(By.xpath("//input[@type='checkbox']"));
		boxes.forEach((box) -> {
			if (box.getAttribute("checked") == null)
				box.click();
		});
		boxes.forEach(a -> {
			assert a.getAttribute("checked") != null;
		});

	}

	@Test
	public void uncheckAll() {
		WebElement checkbox = driver.findElement(By.id("checkboxes"));
		List<WebElement> boxes = checkbox.findElements(By.xpath("//input[@type='checkbox']"));
		boxes.forEach((box) -> {
			if (box.getAttribute("checked") != null)
				box.click();
		});
		boxes.forEach(a -> {
			assert a.getAttribute("checked") == null;
		});

	}

}
