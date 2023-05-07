

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get(" http://localhost:7080/iframe ");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void iFrame() {
		driver.switchTo().frame("mce_0_ifr");
		WebElement body = driver.findElement(By.id("tinymce"));
		body.clear();
		body.sendKeys("test");
		assert body.getText().contains("test");
		
	}

	
}
