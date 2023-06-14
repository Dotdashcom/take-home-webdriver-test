import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlerts {
		
private ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/javascript_alerts");
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	@Test
	public void alert() {

		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		for (WebElement button : buttons) {
			if (button.getText().contains("Alert")) {
				alertTest(button);
			} else if (button.getText().contains("Confirm")) {
				confirmTest(button);
			} else if (button.getText().contains("Prompt")) {
				promptTest(button);
			}
		}
	}

	public void alertTest(WebElement e) {
		e.click();

		driver.switchTo().alert().accept();
		assert driver.findElement(By.id("result")).getText().contains("You successfuly clicked an alert");

	}

	public void confirmTest(WebElement e) {
		e.click();

		driver.switchTo().alert().accept();
		assert driver.findElement(By.id("result")).getText().contains("You clicked: Ok");
	}

	public void promptTest(WebElement e) {
		e.click();
		driver.switchTo().alert().sendKeys("Doing task...");
		driver.switchTo().alert().accept();
		assert driver.findElement(By.id("result")).getText().contains("You entered: Doing task...");

	}
}
