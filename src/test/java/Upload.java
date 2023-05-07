

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upload {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get(" http://localhost:7080/upload");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void load() {
		WebElement chooseFile = driver.findElement(By.id("file-upload"));
		chooseFile.sendKeys(System.getProperty("user.home") + File.separator + "Downloads/some-file.txt");
		driver.findElement(By.id("file-submit")).click();
		WebElement content = driver.findElement(By.id("content"));
		assert content.getText().contains("File Uploaded!");
	}

	
}
