package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowSwitch {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/windows");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void WindowSwitchTest() {
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		ArrayList<String> tabIndexes = new ArrayList<String>(driver.getWindowHandles());
		int Size = tabIndexes.size();
		driver.switchTo().window(tabIndexes.get(Size - 1));
		String Message = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
		assertTrue(Message.contains("New Window"));
		driver.quit();

	}

}
