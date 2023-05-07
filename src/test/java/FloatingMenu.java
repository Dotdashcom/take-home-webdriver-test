

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FloatingMenu {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get(" http://localhost:7080/floating_menu");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void menu() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		
		WebElement menu= driver.findElement(By.id("menu"));
		assert menu.isDisplayed();
		
	}

	
}
