package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Context {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/context_menu");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void ContextTest() {

		Actions action = new Actions(driver);
		WebElement ContextBox = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		action.contextClick(ContextBox).perform();
		String alertMessage = driver.switchTo().alert().getText();
		assertTrue(alertMessage.contains("You selected a context menu"));
		driver.switchTo().alert().accept();
		driver.close();
	}

}
