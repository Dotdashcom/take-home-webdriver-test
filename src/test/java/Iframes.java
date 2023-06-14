import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Iframes {

	
private ChromeDriver driver;
	
    @BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/iframe");
	}

    @AfterMethod
	public void TearDown() {
		driver.close();
	}

	@Test
	public void iFrame() {
		driver.switchTo().frame("mce_0_ifr");
		WebElement body = driver.findElement(By.id("tinymce"));
		body.clear();
		body.sendKeys("some test");
		assert body.getText().contains("some test");

	}
}

