

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dropdown");
		
	}

	@AfterEach
	public void close() {
		driver.close();
	}
	
	@Test
	public void dropDownOption1() {
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByVisibleText("Option 1");
		assert dropdown.getFirstSelectedOption().getAttribute("value").equals("1");
	}

	@Test
	public void dropDownOption2() {
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByVisibleText("Option 2");
		assert dropdown.getFirstSelectedOption().getAttribute("value").equals("2");
	}
}
