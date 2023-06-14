import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicContect {
	
	private ChromeDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_content");
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	@Test
	public void dynamic() {
		WebElement content = driver.findElement(By.id("content"));
		List<WebElement> previousRow = content.findElements(By.className("row"));

		driver.navigate().refresh();
		content = driver.findElement(By.id("content"));
		List<WebElement> row = content.findElements(By.className("row"));

		for (int x = 0; x < previousRow.size(); x++) {
			assert !previousRow.get(x).equals(row.get(x));
		}

	}
}
