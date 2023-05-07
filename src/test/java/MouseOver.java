

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get(" http://localhost:7080/hovers ");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void iFrame() {
		Actions action = new Actions(driver);
		List<WebElement> imgs = driver.findElements(By.className("figure"));
		imgs.forEach(img -> {
			action.moveToElement(img).perform();
			assert img.findElement(By.className("figcaption")).isDisplayed();
		});
		
	}

	
}
