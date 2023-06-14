
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenu {
		
	private ChromeDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/context_menu");
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	@Test
	public void rightClickAlert() {
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.id("hot-spot"))).perform();
		assert driver.switchTo().alert().getText() != null
				&& driver.switchTo().alert().getText().contains("You selected a context menu");
		driver.switchTo().alert().dismiss();

	}
}
