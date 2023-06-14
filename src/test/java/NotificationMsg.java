import java.util.HashSet;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationMsg {
		
private ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/notification_message_rendered");
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	@Test
	public void notification() {
		Set<String> type = new HashSet<String>();
		while (type.size() < 2) {		
			WebElement button = driver.findElement(By.id("content")).findElement(By.tagName("a"));
			button.click();
			WebElement notificationArea = driver.findElement(By.id("flash"));
			String msg = notificationArea.getText();
			type.add(msg);
			assert msg.contains("Action unsuccesful, please try again")
					|| msg.contains("Action successful");

		}
		

}
}