package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class dynamicLoading {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_loading/2");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void dynamicLoadingTest() {
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
		WebElement Text = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]"));
		assertTrue(Text.isDisplayed());
		driver.close();

	}

}
