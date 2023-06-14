import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenNewTab {

	public ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() {					
		System.setProperty("webdriver.chrome.driver","C:\\AssementDriver\\chromedriver.exe");
		WebDriver	driver = new ChromeDriver();
	    driver.get("http://localhost:7080/windows");
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	@Test
	public void openNewTabTest() {
		
		WebElement link = driver.findElement(By.xpath("//a[normalize-space()='Click Here']"));
		link.click();
		String currentWindow = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();

		tabs.stream().filter(s -> !s.contentEquals(currentWindow)).forEach((s) -> {
			driver.switchTo().window(s);
		});
		String text = driver.findElement(By.cssSelector("h3")).getText();
		Assert.assertEquals(text, "New Window");

	}
	
	}
