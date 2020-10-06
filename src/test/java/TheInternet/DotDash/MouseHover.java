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

public class MouseHover {
	public WebDriver driver;

	@BeforeClass
	public void Startup() {

		System.setProperty("webdriver.chrome.driver", "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/hovers");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void MouseHoverTest() throws InterruptedException {

		WebElement ProfileIcon = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/img[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(ProfileIcon).build().perform();
		WebElement Info = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
		Thread.sleep(1000);
		assertTrue(Info.isDisplayed());
	}

}
