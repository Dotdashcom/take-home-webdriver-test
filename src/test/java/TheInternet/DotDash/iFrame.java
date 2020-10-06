package TheInternet.DotDash;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class iFrame {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/iframe");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void iFrameTest() throws InterruptedException {

		driver.switchTo().frame("mce_0_ifr");
		String TextEntered = "Hi I am Testing Iframe";
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys(TextEntered);
		Thread.sleep(1000);
		String TextAppeared = driver.findElement(By.id("tinymce")).getText();
		assertEquals(TextAppeared, TextEntered);
		driver.close();
	}

}
