

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Download {

	private ChromeDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/download");
	}

	@AfterEach
	public void close() {
		driver.close();
	}

	@Test
	public void load() {
		WebElement button = driver.findElement(By.id("content")).findElement(By.tagName("a"));
		Actions action = new Actions(driver);
		action.click(button).perform();

		Map<String, Object> fileMap = new HashMap<>();
		fileMap.put("fileName", "some-file.txt");
		new WebDriverWait(driver, Duration.ofMillis(5000));
		try {
			assert isFileDownloaded("some-file.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public static boolean isFileDownloaded(String fileName)
			throws IOException {
		String folderName = System.getProperty("user.home") + File.separator + "Downloads";

		// Consider file is not downloaded
		boolean fileDownloaded = false;
		File download = new File(folderName+"\\"+fileName);
		if (download!=null) {
			fileDownloaded = true;
			download.delete();
		}
		
		// File Not Found
		return fileDownloaded;
	}
}
