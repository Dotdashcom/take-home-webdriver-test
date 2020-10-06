package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FloatingMenu {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/floating_menu");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void FloatingMenuTest() throws InterruptedException

	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,450)", "");
		WebElement HomeButton = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		assertTrue(HomeButton.isDisplayed());

	}

}
