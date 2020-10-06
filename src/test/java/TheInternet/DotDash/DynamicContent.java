package TheInternet.DotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicContent {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_content");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void dynamicContentTest() throws InterruptedException {
		String text1 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().refresh();
		String text2 = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
		Assert.assertNotEquals(text2, text1);

	}

}
