import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

	public ChromeDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/login");
			}

	@AfterMethod
	public void close() {
		driver.close();
	}
	
	@Test
	public void successLogin() {
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.name("login")).submit();
		assert driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!");

	}

	@Test
	public void invalidUserName() {
		driver.findElement(By.name("username")).sendKeys("tomsmh");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.name("login")).submit();
		assert driver.findElement(By.id("flash")).getText().contains("Your username is invalid!");

	}

	@Test
	public void invalidPassword() {
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecret");
		driver.findElement(By.name("login")).submit();
		assert driver.findElement(By.id("flash")).getText().contains("Your password is invalid!");

	}

	
}