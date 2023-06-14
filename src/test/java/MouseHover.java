import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover {
	
private ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/hovers");
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	@Test
	public void iFrame() {
		Actions action = new Actions(driver);
		List<WebElement> imgs = driver.findElements(By.className("figure"));
		imgs.forEach(img -> {
			action.moveToElement(img).perform();
			assert img.findElement(By.className("figcaption")).isDisplayed();
		});

	}
}
