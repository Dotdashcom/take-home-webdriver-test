package TheInternet.DotDash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class dragAndDrop {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/drag_and_drop");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void DragAndDropTest() throws InterruptedException {

		WebElement A = driver.findElement(By.id("column-a"));
		WebElement B = driver.findElement(By.id("column-b"));
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.dragAndDrop(B, A).build().perform();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='column-a']/header")).getText(), "A");

	}
}
